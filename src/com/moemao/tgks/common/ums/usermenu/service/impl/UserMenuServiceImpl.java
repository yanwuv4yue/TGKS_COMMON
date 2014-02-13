package com.moemao.tgks.common.ums.usermenu.service.impl;

import java.util.List;

import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.ums.usermenu.dao.UserMenuDao;
import com.moemao.tgks.common.ums.usermenu.entity.UserMenuEvt;
import com.moemao.tgks.common.ums.usermenu.entity.UserMenuReq;
import com.moemao.tgks.common.ums.usermenu.service.UserMenuService;

public class UserMenuServiceImpl implements UserMenuService
{
	/**
	 * ﻿UserMenuDao
	 */
	private UserMenuDao ums_userMenuDao;
	
	public List<UserMenuEvt> queryUserMenu(UserMenuReq userMenuReq)
	{
		if (CommonUtil.isEmpty(userMenuReq.getSortSql()))
		{
			userMenuReq.setSortSql(" t.USERID DESC");
		}
		return ums_userMenuDao.ums_queryUserMenu(userMenuReq);
	}
	
	public UserMenuEvt queryUserMenuById(String userId)
	{
		UserMenuReq userMenuReq = new UserMenuReq();
		userMenuReq.setUserId(userId);
		UserMenuEvt userMenuEvt = null;
		List<UserMenuEvt> userMenuList = ums_userMenuDao.ums_queryUserMenu(userMenuReq);
		if (!CommonUtil.isEmpty(userMenuList))
		{
			userMenuEvt = userMenuList.get(0);
		}
		return userMenuEvt;
	}
	
	public int addUserMenu(UserMenuEvt userMenuEvt)
	{
		return ums_userMenuDao.ums_addUserMenu(userMenuEvt);
	}
	
	public int updateUserMenu(UserMenuEvt userMenuEvt)
	{
		return ums_userMenuDao.ums_updateUserMenu(userMenuEvt);
	}
	
	public int deleteUserMenu(List<String> userIds)
	{
		return ums_userMenuDao.ums_deleteUserMenu(userIds);
	}
	
	/**
	 * @return 返回 ums_userMenuDao
	 */
	public UserMenuDao getUms_userMenuDao()
	{
		return ums_userMenuDao;
	}
	
	/**
	 * @param 对ums_userMenuDao进行赋值
	 */
	public void setUms_userMenuDao(UserMenuDao ums_userMenuDao)
	{
		this.ums_userMenuDao = ums_userMenuDao;
	}
	
}