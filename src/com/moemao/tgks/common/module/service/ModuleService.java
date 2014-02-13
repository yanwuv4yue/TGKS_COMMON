package com.moemao.tgks.common.module.service;

import java.util.List;

import com.moemao.tgks.common.core.service.TGKSService;
import com.moemao.tgks.common.module.entity.ModuleEvt;

public interface ModuleService extends TGKSService
{
    /**
     * 
     * @函数功能说明：查询所有的模块
     * @创建者：Ken
     * @创建日期：2012-11-1 上午11:46:14
     * @修改者：
     * @修改日期：
     * @修改内容：
     * @参数：@return
     * @return List<ModuleEvt>
     * @throws
     */
    public List<ModuleEvt> queryModule();
}
