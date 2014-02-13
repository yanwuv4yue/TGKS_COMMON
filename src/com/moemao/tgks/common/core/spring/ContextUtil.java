package com.moemao.tgks.common.core.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

public class ContextUtil
{
	private static ApplicationContext applicationContext;
	
	private static Log log = LogFactory.getLog(ContextUtil.class);
	
	public static void setApplicationContext(
	        ApplicationContext applicationContext)
	{
		synchronized (ContextUtil.class)
		{
			log.debug("setApplicationContext, notifyAll");
			ContextUtil.applicationContext = applicationContext;
			ContextUtil.class.notifyAll();
		}
	}
	
	public static ApplicationContext getApplicationContext()
	{
		synchronized (ContextUtil.class)
		{
			while (applicationContext == null)
			{
				try
				{
					log.debug("getApplicationContext, wait...");
					ContextUtil.class.wait(60000);
					if (applicationContext == null)
					{
						log.warn("Have been waiting for ApplicationContext to be set for 1 minute", new Exception());
					}
				}
				catch (InterruptedException ex)
				{
					log.debug("getApplicationContext, wait interrupted");
				}
			}
		}
		return applicationContext;
	}
	
	public static Object getBean(String name)
	{
		return getApplicationContext().getBean(name);
	}
}
