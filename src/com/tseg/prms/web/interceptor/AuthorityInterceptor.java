package com.tseg.prms.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tseg.prms.web.action.login.LoginAction;

public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		String userId = (String) session.get("USER_ID");
		Object action = invocation.getAction();
		if (action instanceof LoginAction) {
			//System.out.println(1);
			return invocation.invoke();
		}
		if (userId != null && userId.length() > 0) {
			//System.out.println(2);
			return invocation.invoke();
		}
		return Action.LOGIN;
	}

}
