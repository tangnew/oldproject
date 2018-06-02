package com.service.product;

import java.util.List;
import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.task.Task;

import com.model.product.Product;

public interface ProductService {
	public void save(Product product);

	public List<Product> listByUserAndStatus(String userName, List<Long> status);

	public void updateStatus(long productId, long status);

	public Product getProductByProductId(long productId);

	public void submitApplyProcess(String productProcess, Product product,
			Map<String, Object> vars);

	/**
	 * 获取代办任务
	 * 
	 * @return
	 */
	public List<Task> listAgentsAllTaskByUser();

	/**
	 * 获取正在处理的任务
	 * 
	 * @return
	 */
	public List<Product> listAssigneeAllTaskByUser();

	/**
	 * 领取任务
	 * 
	 * @param taskId
	 * @return
	 */
	public Object claimTaskByUser(String taskId);

	/**
	 * 判断该任务是被领取
	 * 
	 * @param taskId
	 * @return
	 */
	public boolean isClaimed(String taskId);

	/**
	 * 获取到当前任务的出路线
	 * 
	 * @param taskId
	 * @return
	 */
	public List<String> getTransitions(String taskId);

	public void dealWithTask(String taskId, String transition);

	public Object getModelOfTask(String taskId);
	
	
	public void updatePassStatus(DelegateExecution execution);

	public void updateFailStatus(DelegateExecution execution);
	
	
	public List<Product> getAuditedTask();
}
