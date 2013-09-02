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

package com.tseg.prms.web.action.login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tseg.prms.service.member.MemberService;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId = "";
	private String password = "";
	private String errorInfo = "";

	public String execute() throws Exception {
		System.out.print(userId);
		String loginInfo = new MemberService().loginSucc(userId, password);
		ActionContext.getContext().getSession().put("USER_ID", userId);
		if (loginInfo.equals(NONE)) {
			setErrorInfo("无此用户，请重新输入");
			return NONE;
		} else if (loginInfo.equals(ERROR)) {
			setErrorInfo("用户名或密码错误");
			return ERROR;
		} else if (loginInfo.equals(SUCCESS)) {
			String memberName = new MemberService().getMemberName(userId);
			ActionContext.getContext().getSession()
					.put("MEMBER_NAME", memberName);
			return SUCCESS;
		}
		return ERROR;
		// return SUCCESS;
	}

	public String logout() {
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

}