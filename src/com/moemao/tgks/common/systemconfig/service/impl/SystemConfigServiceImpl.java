package com.moemao.tgks.common.systemconfig.service.impl;

import java.util.List;

import com.moemao.tgks.common.systemconfig.dao.SystemConfigDao;
import com.moemao.tgks.common.systemconfig.entity.SystemConfigEvt;
import com.moemao.tgks.common.systemconfig.entity.SystemConfigReq;
import com.moemao.tgks.common.systemconfig.service.SystemConfigService;
import com.moemao.tgks.common.tool.CommonUtil;

public class SystemConfigServiceImpl implements SystemConfigService
{
    private SystemConfigDao common_systemConfigDao;
    
    /**
     * 查询数据库系统参数列表
     */
    public List<SystemConfigEvt> querySystemConfigList(SystemConfigReq systemConfigReq)
    {
        return common_systemConfigDao.common_querySystemConfigList(systemConfigReq);
    }
    
    /**
     * 根据ID查询数据库系统参数
     */
    public SystemConfigEvt querySystemConfigById(String id)
    {
        SystemConfigReq systemConfigReq = new SystemConfigReq();
        systemConfigReq.setId(id);
        List<SystemConfigEvt> list = common_systemConfigDao.common_querySystemConfigList(systemConfigReq);
        return CommonUtil.isEmpty(list) ? new SystemConfigEvt() : list.get(0);
    }

    /**
     * 新增系统参数
     */
    public int addSystemConfig(SystemConfigEvt systemConfigEvt)
    {
    	systemConfigEvt.setId(CommonUtil.createUniqueID());
        return common_systemConfigDao.common_addSystemConfig(systemConfigEvt);
    }

    /**
     * 更新系统参数
     */
    public int updateSystemConfig(SystemConfigEvt systemConfigEvt)
    {
        return common_systemConfigDao.common_updateSystemConfig(systemConfigEvt);
    }

    /**
     * 删除系统参数
     */
    public int deleteSystemConfig(List<String> ids)
    {
        return common_systemConfigDao.common_deleteSystemConfig(ids);
    }

    public SystemConfigDao getCommon_systemConfigDao()
    {
        return this.common_systemConfigDao;
    }

    public void setCommon_systemConfigDao(SystemConfigDao common_systemConfigDao)
    {
        this.common_systemConfigDao = common_systemConfigDao;
    }
}
