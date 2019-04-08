/**
 * 
 */
package com.BTP.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


public class LoginInterceptor implements Interceptor {

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String,Object> session=invocation.getInvocationContext().getSession();
		String namespace=invocation.getProxy().getNamespace();
		String usertype=(String) session.get("usertype");
		String actionName=invocation.getInvocationContext().getName();
		System.out.println("***************************");
		
		
		System.out.println("in interceptor");
		System.out.println("action name " + invocation.getInvocationContext().getName());
		namespace=namespace.substring(1);
		System.out.println("namespace " + namespace);
		System.out.println("usertype from session " + session.get("usertype"));
		System.out.println("string usertype from session " + usertype);
		System.out.println("***************************");
		if(session.isEmpty())
		{
			return "login-page";
		}
		else if(!usertype.equals(namespace) && !actionName.equals("logout") && !namespace.isEmpty())
		{
			session.clear();
			return "login-page";
		}
		else {
			return invocation.invoke();
		}
		
		
		
		
	}

}
