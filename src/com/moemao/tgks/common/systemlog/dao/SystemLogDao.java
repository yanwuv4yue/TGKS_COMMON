package com.moemao.tgks.common.systemlog.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.moemao.tgks.common.core.dao.TGKSDao;
import com.moemao.tgks.common.systemlog.entity.SystemLogEvt;
import com.moemao.tgks.common.systemlog.entity.SystemLogReq;

public interface SystemLogDao extends TGKSDao
{
	public List<SystemLogEvt> common_querySystemLog(SystemLogReq systemLogReq)
	        throws DataAccessException;
	
	public int common_addSystemLog(SystemLogEvt systemLogEvt)
	        throws DataAccessException;
	
	public int common_updateSystemLog(SystemLogEvt systemLogEvt)
	        throws DataAccessException;
	
	public int common_deleteSystemLog(List<String> list)
	        throws DataAccessException;
}