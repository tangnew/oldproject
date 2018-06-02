package com.model;

import java.io.Serializable;

import org.activiti.engine.task.Task;

public class CommonModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1843910210514646696L;
	private String taskId;
	private String taskName;
	private String currentDealUser;

	private Task task;
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getCurrentDealUser() {
		return currentDealUser;
	}

	public void setCurrentDealUser(String currentDealUser) {
		this.currentDealUser = currentDealUser;
	}

}
