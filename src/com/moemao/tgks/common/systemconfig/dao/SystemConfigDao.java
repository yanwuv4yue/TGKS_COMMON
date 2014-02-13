package com.moemao.tgks.common.systemconfig.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.moemao.tgks.common.core.dao.TGKSDao;
import com.moemao.tgks.common.systemconfig.entity.SystemConfigEvt;
import com.moemao.tgks.common.systemconfig.entity.SystemConfigReq;

public interface SystemConfigDao extends TGKSDao
{
    public List<SystemConfigEvt> common_querySystemConfigList(SystemConfigReq systemConfigReq) throws DataAccessException;
    
    public int common_addSystemConfig(SystemConfigEvt systemConfigEvt) throws DataAccessException;
    
    public int common_updateSystemConfig(SystemConfigEvt systemConfigEvt) throws DataAccessException;
    
    public int common_deleteSystemConfig(List<String> ids) throws DataAccessException;
}
