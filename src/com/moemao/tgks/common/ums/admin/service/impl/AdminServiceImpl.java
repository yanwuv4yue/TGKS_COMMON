package com.moemao.tgks.common.ums.admin.service.impl;

import java.util.List;

import com.moemao.tgks.common.ums.admin.dao.AdminDao;
import com.moemao.tgks.common.ums.admin.entity.AdminEvt;
import com.moemao.tgks.common.ums.admin.service.AdminService;

public class AdminServiceImpl implements AdminService
{
    private AdminDao ums_adminDao;

    /**
     * 查询所有管理员账号信息
     */
    @Override
    public List<AdminEvt> queryAdminList()
    {
        return ums_adminDao.ums_queryAdminList();
    }

    public AdminDao getUms_adminDao()
    {
        return this.ums_adminDao;
    }

    public void setUms_adminDao(AdminDao ums_adminDao)
    {
        this.ums_adminDao = ums_adminDao;
    }

}
