package com.moemao.tgks.common.module.service.impl;

import java.util.List;

import com.moemao.tgks.common.module.dao.ModuleDao;
import com.moemao.tgks.common.module.entity.ModuleEvt;
import com.moemao.tgks.common.module.service.ModuleService;

public class ModuleServiceImpl implements ModuleService
{
    private ModuleDao common_moduleDao;
    
    /**
     * 查询所有的模块
     */
    public List<ModuleEvt> queryModule()
    {
        return common_moduleDao.common_queryModule();
    }

    public ModuleDao getCommon_moduleDao()
    {
        return this.common_moduleDao;
    }

    public void setCommon_moduleDao(ModuleDao common_moduleDao)
    {
        this.common_moduleDao = common_moduleDao;
    }
}
