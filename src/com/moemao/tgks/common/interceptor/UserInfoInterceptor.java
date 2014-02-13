package com.moemao.tgks.common.interceptor;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.ums.user.entity.UserEvt;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInfoInterceptor extends AbstractInterceptor implements
        ApplicationContextAware
{
	/** 
     * @Fields serialVersionUID
     */ 
    private static final long serialVersionUID = -2703211196452512939L;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
	        throws BeansException
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		
		System.out.println("Action："+invocation.getAction().getClass().getName());
		
		// 取出名为user的session属性
		UserEvt user = (UserEvt) session.get(CommonConstant.USER_INFO);
		
		// 如果没有登陆， 返回重新登陆
		if (user != null)
		{
			return invocation.invoke();
		}
		
		// 没有登陆，将服务器提示设置成一个HttpServletRequest属性
		ctx.put("tip", "您还没有登录，请登陆系统");
		return null;
	}
	
}
