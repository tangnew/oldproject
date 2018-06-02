package com.service.impl.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.history.HistoricIdentityLink;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import com.dao.product.ProductMapper;
import com.model.Status;
import com.model.product.Product;
import com.service.impl.AbstractCommonService;
import com.service.product.ProductService;
import com.spring.util.Constant;
import com.spring.util.SpringUtil;

@Service("productService")
public class ProductServiceImpl extends AbstractCommonService implements
		ProductService {

	@Resource(name = "productMapper")
	private ProductMapper productMapper;

	@Override
	public void save(Product product) {
		productMapper.insert(product);
	}

	@Override
	public List<Product> listByUserAndStatus(String userName, List<Long> status) {
		List<Product> products = productMapper.listByUserAndStatus(userName,
				status);
		for (Product temp : products) {
			temp.setStatusName(Status.getStatusById(temp.getStatus()).getName());
			try {
				Task task = taskService
						.createTaskQuery()
						.processInstanceBusinessKey(
								String.valueOf(temp.getId())).singleResult();
				if (task != null) {
					temp.setTaskId(task.getId());
					temp.setTaskName(task.getName());
					temp.setCurrentDealUser(task.getAssignee());
				}
			} catch (Exception e) {
			}
		}
		return products;
	}

	@Override
	public void updateStatus(long productId, long status) {
		productMapper.updateStatusByProductIdAndStatus(productId, status);
	}

	@Override
	public Product getProductByProductId(long productId) {
		return productMapper.selectByPrimaryKey(productId);
	}

	@Override
	public void submitApplyProcess(String productProcess, Product product,
			Map<String, Object> vars) {
		String businessKey = String.valueOf(product.getId());
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey(productProcess, businessKey, vars);

		Task task = taskService.createTaskQuery()
				.processInstanceId(processInstance.getProcessInstanceId())
				.singleResult();
		taskService.complete(task.getId(), vars);

		updateStatus(product.getId(), Status.START.getId());
	}

	public List<Task> listAgentsAllTaskByUser() {
		String currentUser = SpringUtil.getCurrentUserName();
		List<Task> tasks = taskService.createTaskQuery()
				.taskInvolvedUser(currentUser).taskUnassigned().list();
		return tasks;
	}

	public List<Product> listAssigneeAllTaskByUser() {
		String currentUser = SpringUtil.getCurrentUserName();
		List<Task> assigneeTasks = taskService.createTaskQuery()
				.taskAssignee(currentUser).list();

		List<Product> products = new ArrayList<Product>();
		for (Task temp : assigneeTasks) {
			String taskId = temp.getId();
			Product p = (Product) taskService.getVariable(taskId,
					Constant.MODEL);
			p.setTask(temp);

			products.add(p);
		}

		return products;
	}

	public boolean isClaimed(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		String currentUser = SpringUtil.getCurrentUserName();
		if (task.getAssignee() != null) {
			if (!task.getAssignee().equals(currentUser)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object claimTaskByUser(String taskId) {
		String currentUser = SpringUtil.getCurrentUserName();
		taskService.claim(taskId, currentUser);
		Product product = (Product) taskService.getVariable(taskId,
				Constant.MODEL);
		updateStatus(product.getId(), Status.AUDIT_ING.getId());
		return product;
	}

	public Object getModelOfTask(String taskId) {
		return taskService.getVariable(taskId, Constant.MODEL);
	}

	public List<String> getTransitions(String taskId) {
		List<String> transitionsStr = new ArrayList<String>();
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		ProcessDefinitionEntity pde = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(task.getProcessDefinitionId());
		ExecutionEntity exe = (ExecutionEntity) runtimeService
				.createExecutionQuery().executionId(task.getExecutionId())
				.singleResult();
		ActivityImpl activity = pde.findActivity(exe.getActivityId());
		List<PvmTransition> transitions = activity.getOutgoingTransitions();
		for (PvmTransition pvmTransition : transitions) {
			System.out.println(pvmTransition.getProperty("name"));
			if (pvmTransition.getProperty("name") != null
					&& !pvmTransition.getProperty("name").toString().trim()
							.isEmpty()) {
				transitionsStr.add(pvmTransition.getProperty("name").toString()
						.trim());
			}
		}
		return transitionsStr;
	}

	@Override
	public void dealWithTask(String taskId, String transition) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		taskService.setVariable(taskId, "transition", transition);
		Map<String, Object> vars = taskService.getVariables(task.getId());
		taskService.complete(taskId, vars);
	}

	public List<Product> getAuditedTask() {
		List<Product> products = new ArrayList<Product>();
		String currentUser = SpringUtil.getCurrentUserName();
	
		List<HistoricProcessInstance> lists = historyService
				.createHistoricProcessInstanceQuery()
				.processDefinitionKey(Constant.PRODUCT_PROCESS).involvedUser(currentUser).finished()
				.includeProcessVariables().list();
		for (HistoricProcessInstance temp : lists) {
		List<HistoricIdentityLink> ss=	historyService.getHistoricIdentityLinksForProcessInstance(temp.getId());
		for(HistoricIdentityLink s :ss){
		}
			Product p = (Product) temp.getProcessVariables()
					.get(Constant.MODEL);
			products.add(p);
		}
		// List<HistoricTaskInstance> lists = historyService
		// .createHistoricTaskInstanceQuery().finished()
		// .taskAssignee(currentUser).list();
		//
		// for (HistoricTaskInstance temp : lists) {
		// Product p = (Product)temp.getProcessVariables().get(Constant.MODEL);
		// products.add(p);
		// }
		return products;
	}

	public void updatePassStatus(DelegateExecution execution) {
		Product product = (Product) execution.getVariable(Constant.MODEL);
		updateStatus(product.getId(), Status.SUCCESSFUL.getId());
	}

	public void updateFailStatus(DelegateExecution execution) {
		Product product = (Product) execution.getVariable(Constant.MODEL);
		updateStatus(product.getId(), Status.FAIL.getId());
	}
}
