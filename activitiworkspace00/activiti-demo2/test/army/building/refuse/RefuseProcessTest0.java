package army.building.refuse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.bpmn.diagram.ProcessDiagramGenerator;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.test.PluggableActivitiTestCase;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.junit.Test;
import org.springframework.util.FileCopyUtils;

import com.army.building.model.User;

public class RefuseProcessTest0 extends PluggableActivitiTestCase {

	Map<String, Object> var = new HashMap<String, Object>();

	@Override
	protected void setUp() throws Exception {
		User lisi = new User(1, "lisi");
		User zhangsan = new User(2, "zhangsan");
		User wangwu = new User(3, "wangwu");
		var.put("firstTask", lisi);
		var.put("secondTask", zhangsan);
		var.put("threeTask", wangwu);
	}

	@Test
	@Deployment(resources = "army/building/refuse/RefuseProcess.bpmn")
	public void test0() {
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("refuseProcess", var);

		List<Task> tasks = taskService.createTaskQuery().taskAssignee("lisi")
				.list();
		for (Task task : tasks) {
			System.out.println(task.getProcessDefinitionId() + ";"
					+ task.getAssignee() + ";" + task.getCreateTime() + ";"
					+ task.getName());
			taskService.complete(task.getId());
		}

		tasks = taskService.createTaskQuery().taskAssignee("zhangsan").list();
		for (Task task : tasks) {
			System.out.println(task.getProcessDefinitionId() + ";"
					+ task.getAssignee() + ";" + task.getCreateTime() + ";"
					+ task.getName());
			// taskService.setVariable(task.getId(), "transition", "驳回");
			// taskService.complete(task.getId());
			// taskService.claim(task.getId(), "zhangsan");
			ProcessDefinitionEntity pde = (ProcessDefinitionEntity) repositoryService
					.getProcessDefinition(task.getProcessDefinitionId());
			ExecutionEntity exe = (ExecutionEntity) runtimeService
					.createExecutionQuery().executionId(task.getExecutionId())
					.singleResult();
			ActivityImpl activity = pde.findActivity(exe.getActivityId());
			List<PvmTransition> transitions = activity.getOutgoingTransitions();
			for (PvmTransition pvmTransition : transitions) {
				System.out.println(pvmTransition.getProperty("name"));
			}

			taskService.setVariable(task.getId(), "transitionsss", "通过");
			//taskService.complete(task.getId());
		}

		tasks = taskService.createTaskQuery().list();
		for (Task task : tasks) {
			System.out.println(task.getAssignee() + ";" + task.getCreateTime()
					+ ";" + task.getName());
		}

		Task task = taskService.createTaskQuery().singleResult();
		BpmnModel a = ((RepositoryServiceImpl) repositoryService)
				.getBpmnModel(processInstance.getProcessDefinitionId());
		
		Execution exe = runtimeService.createExecutionQuery().processInstanceId(processInstance.getProcessInstanceId()).singleResult();
		List<String> lists =  runtimeService.getActiveActivityIds(exe.getId());
		InputStream in = ProcessDiagramGenerator.generateDiagram(a,"png",lists);
		OutputStream out;
		try {
			out = new FileOutputStream(new File("c://a.png"));
			FileCopyUtils.copy(in, out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	System.out.println(task.getProcessDefinitionId()+";"+processInstance.getProcessInstanceId());	
	}
}
