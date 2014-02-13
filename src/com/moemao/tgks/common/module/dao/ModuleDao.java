package com.moemao.tgks.common.module.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.moemao.tgks.common.core.dao.TGKSDao;
import com.moemao.tgks.common.module.entity.ModuleEvt;

public interface ModuleDao extends TGKSDao
{
    /**
     * 
     * @函数功能说明：查询系统中所有的模块
     * @创建者：Ken
     * @创建日期：2012-11-1 上午11:36:35
     * @修改者：
     * @修改日期：
     * @修改内容：
     * @参数：@return
     * @参数：@throws DataAccessException
     * @return List<ModuleEvt>
     * @throws
     */
    public List<ModuleEvt> common_queryModule() throws DataAccessException;
}
