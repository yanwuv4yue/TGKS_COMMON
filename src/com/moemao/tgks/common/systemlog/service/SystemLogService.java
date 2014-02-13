package com.moemao.tgks.common.systemlog.service;

import java.util.List;

import com.moemao.tgks.common.systemlog.entity.SystemLogEvt;
import com.moemao.tgks.common.systemlog.entity.SystemLogReq;

public interface SystemLogService
{
	public List<SystemLogEvt> querySystemLog(SystemLogReq systemLogReq);
	
	public SystemLogEvt querySystemLogById(String id);
	
	public int addSystemLog(SystemLogEvt systemLogEvt);
	
	public int updateSystemLog(SystemLogEvt systemLogEvt);
	
	public int deleteSystemLog(List<String> ids);
	
}