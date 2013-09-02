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

package com.tseg.prms.web.action.report;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tseg.prms.model.TableProject;
import com.tseg.prms.service.member.MemberService;
import com.tseg.prms.service.report.ReportService;

public class ReportAction extends ActionSupport {

	private String content;
	private String reportDate;
	private String project;

	private String reportNum;

	public String execute() throws Exception {
		// ReportService rs = new ReportService();
		// rs.writeReport((int)System.currentTimeMillis(), reportor, reportDate,
		// content, false);
		String userId = (String) ActionContext.getContext().getSession().get("USER_ID");
		reportNum = ""+new ReportService().getReportsNum(Integer.parseInt(userId));
		
		Set<TableProject> projects = new MemberService().getProjects(Integer.parseInt(userId));
		Map participateProjects =new HashMap();
		for(TableProject project :projects){
			participateProjects.put( project.getProjectId(),project.getProjectName());
		}
		ActionContext.getContext().getSession().put("participateProjects",participateProjects);
		return SUCCESS;
	}

	public String addReport() throws Exception {
		ReportService rs = new ReportService();
		String reportor = (String)ActionContext.getContext().getSession().get("USER_ID");
		rs.writeReport(project.trim().substring(0, project.indexOf(' ')), reportor, reportDate, content, ReportService.WEEK_REPORT);
		return SUCCESS;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getReportNum() {
		return reportNum;
	}

	public void setReportNum(String reportNum) {
		this.reportNum = reportNum;
	}

}