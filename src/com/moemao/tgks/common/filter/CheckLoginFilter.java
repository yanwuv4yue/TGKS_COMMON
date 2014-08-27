package com.moemao.tgks.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moemao.tgks.common.tool.CommonConstant;

/**
 * 
 * 项目名称：TGKS_COMMON
 * 类名称：CheckLoginFilter
 * 类描述：用于检查当前用户是否处于登录状态
 * 创建人：Ken
 * 创建时间：2013-10-24 上午10:40:57
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 *
 */
public class CheckLoginFilter implements Filter
{
	protected FilterConfig filterConfig = null;
	private String redirectURL = null;
	private List<String> notCheckURLList = new ArrayList<String>();
	private String sessionKey = null;
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
	        throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		HttpSession session = request.getSession();
		
		if(!(request.getRequestURI().contains("login.jsp") || request.getRequestURI().contains("login.action")
				|| request.getRequestURI().contains("register.jsp") || request.getRequestURI().contains("register.action")))
		{
			if (sessionKey == null)
			{
				filterChain.doFilter(request, response);
				return;
			}
			if ((!checkRequestURIIntNotFilterList(request)) && session.getAttribute(sessionKey) == null)
			{
				session.setAttribute(CommonConstant.LOGIN_PLEASE, "请先登录");
				response.sendRedirect(request.getContextPath() + redirectURL);
				return;
			}
		}
		
		filterChain.doFilter(servletRequest, servletResponse);
	}
	
	public void destroy()
	{
		notCheckURLList.clear();
	}
	
	private boolean checkRequestURIIntNotFilterList(HttpServletRequest request)
	{
		String uri = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());
		return notCheckURLList.contains(uri);
	}
	
	public void init(FilterConfig filterConfig) throws ServletException
	{
		this.filterConfig = filterConfig;
		redirectURL = filterConfig.getInitParameter("redirectURL");
		sessionKey = filterConfig.getInitParameter("checkSessionKey");
		
		String notCheckURLListStr = filterConfig.getInitParameter("notCheckURLList");
		
		if (notCheckURLListStr != null)
		{
			StringTokenizer st = new StringTokenizer(notCheckURLListStr, ";");
			notCheckURLList.clear();
			while (st.hasMoreTokens())
			{
				notCheckURLList.add(st.nextToken());
			}
		}
	}
}
