package com.moemao.tgks.common.ums.admin.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.moemao.tgks.common.core.dao.TGKSDao;
import com.moemao.tgks.common.ums.admin.entity.AdminEvt;

public interface AdminDao extends TGKSDao
{
    /**
     * 查询所有管理员账号
     * @return List<AdminEvt>
     * @throws DataAccessException
     */
    public List<AdminEvt> ums_queryAdminList() throws DataAccessException;
    
    /**
     * 添加管理员账号
     * @param adminEvt 管理员账号信息
     * @return
     * @throws DataAccessException
     */
    public int ums_addAdmin(AdminEvt adminEvt) throws DataAccessException;
}
