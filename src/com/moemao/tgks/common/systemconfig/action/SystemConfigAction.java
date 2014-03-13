package com.moemao.tgks.common.systemconfig.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.moemao.tgks.common.core.action.TGKSAction;
import com.moemao.tgks.common.systemconfig.entity.SystemConfigEvt;
import com.moemao.tgks.common.systemconfig.entity.SystemConfigReq;
import com.moemao.tgks.common.systemconfig.service.SystemConfigService;
import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.tool.StringUtil;

public class SystemConfigAction extends TGKSAction
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4929399987537993249L;
    
    private static Log logger = LogFactory.getLog(SystemConfigAction.class);

    private SystemConfigReq systemConfigReq;

    private SystemConfigEvt systemConfigEvt;

    private List<SystemConfigEvt> list;
    
    private SystemConfigService common_systemConfigService;
    
    public String systemConfigManager()
    {
        
        return SUCCESS;
    }
    
    public String querySystemConfig()
    {
        list = common_systemConfigService.querySystemConfigList(systemConfigReq);
        return SUCCESS;
    }
    
    public String editSystemConfigPage()
    {
    	CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "SystemConfigAction.editSystemConfigPage");
    	
    	String id = this.getRequest().getParameter("id");
        if (!CommonUtil.isEmpty(id))
        {
        	systemConfigEvt = common_systemConfigService.querySystemConfigById(id);
        }
        
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "SystemConfigAction.editSystemConfigPage");
    	return SUCCESS;
    }
    
    public String editSystemConfig()
    {
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "SystemConfigAction.editSystemConfig");
        
        int result = 0;
        if (CommonUtil.isEmpty(systemConfigEvt.getId()))
        {
        	result = common_systemConfigService.addSystemConfig(systemConfigEvt);
        	CommonUtil.systemLog("common/editSystemConfig.action", CommonConstant.SYSTEMLOG_TYPE_1, result == 0 ? CommonConstant.FAILD : CommonConstant.SUCCESS, String.format("新增系统参数\n%S", systemConfigEvt.toString()));
        }
        else
        {
        	result = common_systemConfigService.updateSystemConfig(systemConfigEvt);
        	CommonUtil.systemLog("common/editSystemConfig.action", CommonConstant.SYSTEMLOG_TYPE_2, result == 0 ? CommonConstant.FAILD : CommonConstant.SUCCESS, String.format("修改系统参数\n%S", systemConfigEvt.toString()));
        }
        
        CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));        
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "SystemConfigAction.editSystemConfig");
        
        return SUCCESS;
    }
    
    public String deleteSystemConfig()
    {
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "SystemConfigAction.deleteSystemConfig");
        
        String ids = this.getRequest().getParameter("ids");
        int result = common_systemConfigService.deleteSystemConfig(CommonUtil.stringToList(ids));
        CommonUtil.systemLog("common/deleteSystemConfig.action", CommonConstant.SYSTEMLOG_TYPE_3, result == 0 ? CommonConstant.FAILD : CommonConstant.SUCCESS, String.format("删除系统参数\nID:%S", ids));
        CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));
        
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "SystemConfigAction.deleteSystemConfig");
        
        return SUCCESS;
    }

    public static Log getLogger()
    {
        return logger;
    }

    public static void setLogger(Log logger)
    {
        SystemConfigAction.logger = logger;
    }

    public SystemConfigReq getSystemConfigReq()
    {
        return this.systemConfigReq;
    }

    public void setSystemConfigReq(SystemConfigReq systemConfigReq)
    {
        this.systemConfigReq = systemConfigReq;
    }

    public SystemConfigEvt getSystemConfigEvt()
    {
        return this.systemConfigEvt;
    }

    public void setSystemConfigEvt(SystemConfigEvt systemConfigEvt)
    {
        this.systemConfigEvt = systemConfigEvt;
    }

    public List<SystemConfigEvt> getList()
    {
        return this.list;
    }

    public void setList(List<SystemConfigEvt> list)
    {
        this.list = list;
    }

    public SystemConfigService getCommon_systemConfigService()
    {
        return this.common_systemConfigService;
    }

    public void setCommon_systemConfigService(
            SystemConfigService common_systemConfigService)
    {
        this.common_systemConfigService = common_systemConfigService;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
}
