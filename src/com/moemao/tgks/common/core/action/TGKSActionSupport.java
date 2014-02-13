package com.moemao.tgks.common.core.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.ServletContextSingleton;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

public class TGKSActionSupport extends ActionSupport implements SessionAware,
        ServletRequestAware, ServletResponseAware, ApplicationAware,
        ParameterAware
{
    private static final String RAWTYPES = "rawtypes";

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6894955896052678276L;

    private static ApplicationContext webApplicationContext = null;

    private HttpServletRequest request;

    private HttpServletResponse response;

    @SuppressWarnings(RAWTYPES)
    private Map session;

    @SuppressWarnings(RAWTYPES)
    private Map application;

    @SuppressWarnings(RAWTYPES)
    private Map parameters;

    public TGKSActionSupport()
    {
        this.request = null;

        this.response = null;

        this.session = null;

        this.application = null;

        this.parameters = null;
    }

    public static ApplicationContext getWebApplicationContext()
    {
        if (webApplicationContext == null)
        {
            webApplicationContext = WebApplicationContextUtils
                    .getWebApplicationContext(ServletContextSingleton
                            .getInstance().getServletContext());
        }
        return webApplicationContext;
    }

    protected String getRequestContextPath()
    {
        return this.request.getContextPath();
    }

    @SuppressWarnings(RAWTYPES)
    public void setSession(Map session_temp)
    {
        this.session = session_temp;
    }

    public void setServletRequest(HttpServletRequest request_temp)
    {
        this.request = request_temp;
    }

    public void setServletResponse(HttpServletResponse response_temp)
    {
        this.response = response_temp;
    }

    @SuppressWarnings(RAWTYPES)
    public void setApplication(Map application_temp)
    {
        this.application = application_temp;
    }

    @SuppressWarnings(RAWTYPES)
    public void setParameters(Map parameters_temp)
    {
        this.parameters = parameters_temp;
    }

    @SuppressWarnings(RAWTYPES)
    public Map getApplication()
    {
        return this.application;
    }

    @SuppressWarnings(RAWTYPES)
    public Map getParameters()
    {
        return this.parameters;
    }

    public HttpServletRequest getRequest()
    {
        return this.request;
    }

    public HttpServletResponse getResponse()
    {
        return this.response;
    }

    public static ServletContext getServletContext()
    {
        return ServletActionContext.getServletContext();
    }

    @SuppressWarnings(RAWTYPES)
    public Map getSession()
    {
        return this.session;
    }

    public static void setWebApplicationContext(
            ApplicationContext _applicationContext)
    {
        webApplicationContext = _applicationContext;
    }

    public void addFieldError(String fieldName, String errorMessage)
    {
        if (null == fieldName)
        {
            throw new IllegalArgumentException("Field name is null");
        }
        super.addFieldError(fieldName, errorMessage);
    }
}
