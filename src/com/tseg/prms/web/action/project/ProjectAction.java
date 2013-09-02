/*
 * $Id: Login.java 471756 2006-11-06 15:01:43Z husted $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.tseg.prms.web.action.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tseg.prms.model.TableProject;
import com.tseg.prms.service.member.MemberService;
import com.tseg.prms.service.project.ProjectService;
import com.tseg.prms.utility.SendEmailUtil;

public class ProjectAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String projectName;
	private String projectAdmin;
	private String projectDesc;
	private String projectNum;
	private String memberId;
	private String taskMemberId;
	private String taskContent;

	public String execute() throws Exception {
		projectNum = new ProjectService().getProjects().size() + "";

		List<TableProject> projectList = new ProjectService().getProjects();
		Map<Integer, String> projects = new HashMap<Integer, String>();
		for (TableProject project : projectList) {
			projects.put(project.getProjectId(), project.getProjectName());
		}
		ActionContext.getContext().getSession().put("allProjectMap", projects);
		return SUCCESS;
	}

	public String addProject() throws Exception {
		ProjectService ps = new ProjectService();
		ps.addProject(projectName,
				projectAdmin.trim().substring(0, projectAdmin.indexOf(' ')),
				projectDesc);
		return SUCCESS;
	}

	public String addGroupMember() {
		String projectId = (String) ActionContext.getContext().getSession()
				.get("CURRENT_PROJECT");
		new ProjectService().addMemberToProject(projectId, memberId, 0);

		return SUCCESS;
	}

	public String addTask() {
		String email = new MemberService().getMemberEmail(taskMemberId);
		String name = new MemberService().getMemberName(taskMemberId);
		String projectId = (String) ActionContext.getContext().getSession()
				.get("CURRENT_PROJECT");
		String projectName = new ProjectService().getProjectName(projectId);
		SendEmailUtil.sendTaskMail(email, name, projectName, taskContent);
		return SUCCESS;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectAdmin() {
		return projectAdmin;
	}

	public void setProjectAdmin(String projectAdmin) {
		this.projectAdmin = projectAdmin;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getTaskMemberId() {
		return taskMemberId;
	}

	public void setTaskMemberId(String taskMemberId) {
		this.taskMemberId = taskMemberId;
	}

	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

}