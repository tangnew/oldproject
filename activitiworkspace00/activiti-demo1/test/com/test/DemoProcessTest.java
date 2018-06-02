package com.test;

import java.io.FileInputStream;
import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class DemoProcessTest {
	// diagrams实际路径
	private static String realPath = "E:\\workspace5\\activiti-demo0\\resource";

	public static void main(String[] args) throws Exception {

		// 创建 Activiti流程引擎
		// 方式一 自动寻找activiti.cfg.xml
		// ProcessEngine processEngine =
		// ProcessEngines.getDefaultProcessEngine();

		// 方式二 指定加载activiti.cfg.xml
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(
						"activiti.cfg.xml").buildProcessEngine();

		// 取得 Activiti 服务
		RepositoryService repositoryService = processEngine
				.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();

		// 部署流程定义
		repositoryService
				.createDeployment()
				.addInputStream("MyProcess.bpmn",
						new FileInputStream(realPath + "\\MyProcess.bpmn"))
				.addInputStream("MyProcess.png",
						new FileInputStream(realPath + "\\MyProcess.png"))
				.deploy();

		// 启动流程实例
		ProcessInstance instance = processEngine.getRuntimeService()
				.startProcessInstanceByKey("myProcess");
		String procId = instance.getId();
		System.out.println("procId:" + procId);

		// 获得第一个任务
		TaskService taskService = processEngine.getTaskService();
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
			taskService.claim(task.getId(), "testUser");
		}

		// 完成第二个任务结束结束流程
		for (Task task : tasks) {
			taskService.complete(task.getId());
		}

		// 核实流程是否结束
		HistoryService historyService = processEngine.getHistoryService();
		HistoricProcessInstance historicProcessInstance = historyService
				.createHistoricProcessInstanceQuery().processInstanceId(procId)
				.singleResult();
		System.out.println("Process instance end time: "
				+ historicProcessInstance.getEndTime());
	}
}
