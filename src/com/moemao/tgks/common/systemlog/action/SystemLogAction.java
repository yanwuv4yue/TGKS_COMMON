package com.moemao.tgks.common.systemlog.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.moemao.tgks.common.core.action.TGKSAction;
import com.moemao.tgks.common.systemlog.entity.SystemLogEvt;
import com.moemao.tgks.common.systemlog.entity.SystemLogReq;
import com.moemao.tgks.common.systemlog.service.SystemLogService;
import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.tool.StringUtil;

public class SystemLogAction extends TGKSAction
{
	
	/** 
     * serialVersionUID
     */ 
    private static final long serialVersionUID = -8677466653811891866L;

	private static Log logger = LogFactory.getLog(SystemLogAction.class);
	
	/**
	 * ﻿SystemLog业务接口
	 */
	private SystemLogService common_systemLogService;
	
	/**
	 * 查询结果集
	 */
	private List<SystemLogEvt> list;
	
	/**
	 * ﻿SystemLogEvt对象
	 */
	private SystemLogEvt systemLogEvt;
	
	/**
	 * ﻿SystemLog查询条件封装对象
	 */
	private SystemLogReq systemLogReq = new SystemLogReq();
	
	public String systemLogManager()
	{
		return SUCCESS;
	}
	
	public String querySystemLog()
	{
		list = common_systemLogService.querySystemLog(systemLogReq);
		return SUCCESS;
	}
	
	public String editSystemLogPage()
	{
		String id = this.getRequest().getParameter("id");
		if (!CommonUtil.isEmpty(id))
		{
			systemLogEvt = common_systemLogService.querySystemLogById(id);
		}
		return SUCCESS;
	}
	
	public String editSystemLog()
	{
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "SystemLogAction.updateSystemLog");
		int result = 0;
		if (CommonUtil.isEmpty(systemLogEvt.getId()))
		{
			result = common_systemLogService.addSystemLog(systemLogEvt);
		}
		else
		{
			result = common_systemLogService.updateSystemLog(systemLogEvt);
		}
		CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, "SystemLogAction.updateSystemLog");
		return SUCCESS;
	}
	
	public String deleteSystemLog()
	{
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "SystemLogAction.deleteSystemLog");
		String ids = this.getRequest().getParameter("ids");
		int result = common_systemLogService.deleteSystemLog(CommonUtil.stringToList(ids));
		CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, "SystemLogAction.deleteSystemLog");
		return SUCCESS;
	}
	
	/**
	 * @return 返回 common_systemLogService
	 */
	public SystemLogService getCommon_systemLogService()
	{
		return common_systemLogService;
	}
	
	/**
	 * @param 对common_systemLogService进行赋值
	 */
	public void setCommon_systemLogService(
	        SystemLogService common_systemLogService)
	{
		this.common_systemLogService = common_systemLogService;
	}
	
	/**
	 * @return 返回 list
	 */
	public List<SystemLogEvt> getList()
	{
		return list;
	}
	
	/**
	 * @param 对list进行赋值
	 */
	public void setList(List<SystemLogEvt> list)
	{
		this.list = list;
	}
	
	/**
	 * @return 返回 systemLogEvt
	 */
	public SystemLogEvt getSystemLogEvt()
	{
		return systemLogEvt;
	}
	
	/**
	 * @param 对systemLogEvt进行赋值
	 */
	public void setSystemLogEvt(SystemLogEvt systemLogEvt)
	{
		this.systemLogEvt = systemLogEvt;
	}
	
	/**
	 * @return 返回 systemLogReq
	 */
	public SystemLogReq getSystemLogReq()
	{
		return systemLogReq;
	}
	
	/**
	 * @param 对systemLogReq进行赋值
	 */
	public void setSystemLogReq(SystemLogReq systemLogReq)
	{
		this.systemLogReq = systemLogReq;
	}
	
}