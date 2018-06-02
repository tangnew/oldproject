package army.building.bpmn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.test.PluggableActivitiTestCase;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

import com.army.building.model.User;

public class FirstProcessTest1 extends PluggableActivitiTestCase {

  
	@Test
	@Deployment(resources="army/building/bpmn/FirstProcess.bpmn")
	public void test0() {

		Map<String, Object> var = new HashMap<String, Object>();
		User lisi = new User(1, "lisi");
		User zhangsan = new User(2, "zhangsan");
		var.put("firstTask", lisi);
		var.put("secondTask", zhangsan);
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("firstProcess", var);

		lisi = (User) runtimeService.getVariable("firstTask", "firstTask");
		System.out.println("lisi:" + lisi.getName());

		List<Task> tasks = taskService.createTaskQuery().taskAssignee("lisi")
				.list();
		for (Task task : tasks) {
			System.out.println(task.getAssignee() + ";" + task.getCreateTime());

			taskService.complete(task.getId());
		}

		tasks = taskService.createTaskQuery().taskAssignee("zhangsan").list();
		for (Task task : tasks) {
			System.out.println(task.getAssignee() + ";" + task.getCreateTime());
			// taskService.complete(task.getId());
		}
	}
}
