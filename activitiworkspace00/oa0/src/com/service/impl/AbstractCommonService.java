package com.service.impl;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

public abstract class AbstractCommonService {
	@Resource(name = "runtimeService")
	protected RuntimeService runtimeService;

	@Resource(name = "taskService")
	protected TaskService taskService;

	@Resource(name = "repositoryService")
	protected RepositoryService repositoryService;

	@Resource(name = "historyService")
	protected HistoryService historyService;
	
	@Resource(name = "identityService")
	protected IdentityService identityService;
	
}
