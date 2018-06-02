package army.building.bpmn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.army.building.model.User;

public class FirstProcessTest0 {

	private static ApplicationContext application;

	public static void main(String[] args) {
		application = new ClassPathXmlApplicationContext("/application*.xml");

		RepositoryService repositoryService = application.getBean(
				"repositoryService", RepositoryService.class);
		repositoryService.createDeployment()
				.addClasspathResource("army/building/bpmn/FirstProcess.bpmn")
				.deploy();

		Map<String, Object> var = new HashMap<String, Object>();
		RuntimeService runtimeService = application.getBean("runtimeService",
				RuntimeService.class);
		User lisi = new User(1, "lisi");
		User zhangsan = new User(2, "zhangsan");
		var.put("firstTask", lisi);
		var.put("secondTask", zhangsan);
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("firstProcess", var);

		lisi = (User) runtimeService.getVariable("firstTask", "firstTask");
		System.out.println("lisi:" + lisi.getName());
		TaskService taskService = application.getBean("taskService",
				TaskService.class);

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
