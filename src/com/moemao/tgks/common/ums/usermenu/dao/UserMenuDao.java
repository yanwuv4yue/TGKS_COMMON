package com.moemao.tgks.common.ums.usermenu.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.moemao.tgks.common.core.dao.TGKSDao;
import com.moemao.tgks.common.ums.usermenu.entity.UserMenuEvt;
import com.moemao.tgks.common.ums.usermenu.entity.UserMenuReq;

public interface UserMenuDao extends TGKSDao
{
	public List<UserMenuEvt> ums_queryUserMenu(UserMenuReq userMenuReq) throws DataAccessException;
	
	public int ums_addUserMenu(UserMenuEvt userMenuEvt) throws DataAccessException;
	
	public int ums_updateUserMenu(UserMenuEvt userMenuEvt) throws DataAccessException;
	
	public int ums_deleteUserMenu(List<String> list) throws DataAccessException;
}