package com.moemao.tgks.common.systemlog.service.impl;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.moemao.tgks.common.core.spring.ContextUtil;
import com.moemao.tgks.common.systemlog.dao.SystemLogDao;
import com.moemao.tgks.common.systemlog.entity.SystemLogEvt;
import com.moemao.tgks.common.systemlog.entity.SystemLogReq;
import com.moemao.tgks.common.systemlog.service.SystemLogService;
import com.moemao.tgks.common.tool.CommonUtil;

public class SystemLogServiceImpl implements SystemLogService, ApplicationContextAware
{
	/**
	 * ﻿SystemLogDao
	 */
	private SystemLogDao common_systemLogDao;
	
	public List<SystemLogEvt> querySystemLog(SystemLogReq systemLogReq)
	{
		if (CommonUtil.isEmpty(systemLogReq.getSortSql()))
		{
			systemLogReq.setSortSql(" t.ID DESC");
		}
		return common_systemLogDao.common_querySystemLog(systemLogReq);
	}
	
	public SystemLogEvt querySystemLogById(String id)
	{
		SystemLogReq systemLogReq = new SystemLogReq();
		systemLogReq.setId(id);
		SystemLogEvt systemLogEvt = null;
		List<SystemLogEvt> systemLogList = common_systemLogDao
		        .common_querySystemLog(systemLogReq);
		if (!CommonUtil.isEmpty(systemLogList))
		{
			systemLogEvt = systemLogList.get(0);
		}
		return systemLogEvt;
	}
	
	public int addSystemLog(SystemLogEvt systemLogEvt)
	{
		systemLogEvt.setId(CommonUtil.createUniqueID());
		return common_systemLogDao.common_addSystemLog(systemLogEvt);
	}
	
	public int updateSystemLog(SystemLogEvt systemLogEvt)
	{
		return common_systemLogDao.common_updateSystemLog(systemLogEvt);
	}
	
	public int deleteSystemLog(List<String> ids)
	{
		return common_systemLogDao.common_deleteSystemLog(ids);
	}
	
	/**
	 * @return 返回 common_systemLogDao
	 */
	public SystemLogDao getCommon_systemLogDao()
	{
		return common_systemLogDao;
	}
	
	/**
	 * @param 对common_systemLogDao进行赋值
	 */
	public void setCommon_systemLogDao(SystemLogDao common_systemLogDao)
	{
		this.common_systemLogDao = common_systemLogDao;
	}

	@Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException
    {
		ContextUtil.setApplicationContext(applicationContext);
    }
}