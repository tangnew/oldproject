package com.test;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoProcessTest0 {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContent.xml");

		RuntimeService runtimeService = (RuntimeService) applicationContext
				.getBean("runtimeService");

		// 启动流程实例
		ProcessInstance instance = runtimeService
				.startProcessInstanceByKey("myProcess");
		String procId = instance.getId();
		System.out.println("procId:" + procId);

		// 获得第一个任务
		TaskService taskService = (TaskService) applicationContext
				.getBean("taskService");

		List<Task> tasks = taskService.createTaskQuery()
				.taskDefinitionKey("firstTask").list();
		for (Task task : tasks) {
			System.out.println("Following task is: taskID -" + task.getId()
					+ " taskName -" + task.getName());
			// 认领任务
			taskService.claim(task.getId(), "testUser");
		}

		// 查看testUser 现在是否能够获取到该任务
		tasks = taskService.createTaskQuery().taskAssignee("testUser").list();
		for (Task task : tasks) {
			System.out.println("Task for testUser: " + task.getName());
			// 完成任务
			taskService.complete(task.getId());
		}
		System.out.println("Number of tasks for testUser: "
				+ taskService.createTaskQuery().taskAssignee("testUser")
						.count());

		// 获取并认领第二个任务
		tasks = taskService.createTaskQuery().taskDefinitionKey("secondTask")
				.list();
		for (Task task : tasks) {
			System.out.println("Following task is : taskID -" + task.getId()
					+ " taskName -" + task.getName());
			taskService.claim(task.getId(), "testUserZhangSan");
		}

		// 完成第二个任务结束结束流程
		for (Task task : tasks) {
			taskService.complete(task.getId());
		}

		// 核实流程是否结束
		HistoryService historyService = (HistoryService) applicationContext
				.getBean("historyService");
		HistoricProcessInstance historicProcessInstance = historyService
				.createHistoricProcessInstanceQuery().processInstanceId(procId)
				.singleResult();
		System.out.println("Process instance end time: "
				+ historicProcessInstance.getEndTime());
	}
}
