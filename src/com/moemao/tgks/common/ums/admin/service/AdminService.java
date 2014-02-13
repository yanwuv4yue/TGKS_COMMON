package com.moemao.tgks.common.ums.admin.service;

import java.util.List;

import com.moemao.tgks.common.core.service.TGKSService;
import com.moemao.tgks.common.ums.admin.entity.AdminEvt;

public interface AdminService extends TGKSService
{
    public List<AdminEvt> queryAdminList();
}
