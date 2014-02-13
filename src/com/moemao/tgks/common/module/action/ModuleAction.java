package com.moemao.tgks.common.module.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.moemao.tgks.common.core.action.TGKSAction;
import com.moemao.tgks.common.module.entity.ModuleEvt;
import com.moemao.tgks.common.module.service.ModuleService;

public class ModuleAction extends TGKSAction
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6488016775743981299L;
    
    private static Log logger = LogFactory.getLog(ModuleAction.class);
    
    private ModuleEvt moduleEvt;
    
    private List<ModuleEvt> list;
    
    private ModuleService common_moduleService;
    
    /**
     * 
     * @函数功能说明：查询所有的模块
     * @创建者：Ken
     * @创建日期：2012-11-1 下午2:16:37
     * @修改者：
     * @修改日期：
     * @修改内容：
     * @参数：@return
     * @return String
     * @throws
     */
    public String queryModule()
    {
        list = common_moduleService.queryModule();
        return SUCCESS;
    }

    public static Log getLogger()
    {
        return logger;
    }

    public static void setLogger(Log logger)
    {
        ModuleAction.logger = logger;
    }

    public ModuleEvt getModuleEvt()
    {
        return this.moduleEvt;
    }

    public void setModuleEvt(ModuleEvt moduleEvt)
    {
        this.moduleEvt = moduleEvt;
    }

    public List<ModuleEvt> getList()
    {
        return this.list;
    }

    public void setList(List<ModuleEvt> list)
    {
        this.list = list;
    }

    public ModuleService getCommon_moduleService()
    {
        return this.common_moduleService;
    }

    public void setCommon_moduleService(ModuleService common_moduleService)
    {
        this.common_moduleService = common_moduleService;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
}
