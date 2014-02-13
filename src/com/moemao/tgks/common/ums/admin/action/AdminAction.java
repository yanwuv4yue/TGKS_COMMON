package com.moemao.tgks.common.ums.admin.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.moemao.tgks.common.core.action.TGKSAction;
import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.ums.admin.entity.AdminEvt;
import com.moemao.tgks.common.ums.admin.entity.AdminReq;
import com.moemao.tgks.common.ums.admin.service.AdminService;

public class AdminAction extends TGKSAction
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1625370523348044268L;
    
    private static Log logger = LogFactory.getLog(AdminAction.class);
    
    private AdminReq adminReq;
    
    private AdminEvt adminEvt;
    
    private List<AdminEvt> list;
    
    private AdminService ums_adminService; 
    
    /**
     * 查询所有管理员账号
     * @return
     */
    public String queryAdminList()
    {
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "AdminAction.queryAdminList");
        
        list = ums_adminService.queryAdminList();
        
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, "AdminAction.queryAdminList");
        
        return SUCCESS;
    }

    public AdminReq getAdminReq()
    {
        return this.adminReq;
    }

    public void setAdminReq(AdminReq adminReq)
    {
        this.adminReq = adminReq;
    }

    public AdminEvt getAdminEvt()
    {
        return this.adminEvt;
    }

    public void setAdminEvt(AdminEvt adminEvt)
    {
        this.adminEvt = adminEvt;
    }

    public List<AdminEvt> getList()
    {
        return this.list;
    }

    public void setList(List<AdminEvt> list)
    {
        this.list = list;
    }

    public AdminService getUms_adminService()
    {
        return this.ums_adminService;
    }

    public void setUms_adminService(AdminService ums_adminService)
    {
        this.ums_adminService = ums_adminService;
    }
}
