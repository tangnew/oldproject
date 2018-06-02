package com.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContent.xml")
public class DemoProcessTest1 {
	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	@Rule
	public ActivitiRule activitiSpringRule;

	@Test
	//@Deployment(表示默认的bmp)
	public void simpleProcessTest() {
		runtimeService.startProcessInstanceByKey("myProcess");
		List<Task> tasks = taskService.createTaskQuery()
				.taskDefinitionKey("firstTask").list();
		for (Task temp : tasks) {
			System.out.println(temp.getId() + "=" + temp.getName());
			taskService.complete(temp.getId());
		}

		System.out.println("result=" +  runtimeService.createProcessInstanceQuery().count());
	}

}
