package com.moemao.tgks.common.ums.user.service.impl;

import java.util.List;

import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.ums.tool.UmsConstant;
import com.moemao.tgks.common.ums.tool.UmsUtil;
import com.moemao.tgks.common.ums.user.dao.UserDao;
import com.moemao.tgks.common.ums.user.entity.UserEvt;
import com.moemao.tgks.common.ums.user.entity.UserReq;
import com.moemao.tgks.common.ums.user.service.UserService;

public class UserServiceImpl implements UserService
{
	/**
	 * ﻿UserDao
	 */
	private UserDao ums_userDao;
	
	public List<UserEvt> queryUser(UserReq userReq)
	{
		if (CommonUtil.isEmpty(userReq.getSortSql()))
		{
			userReq.setSortSql(" t.ID DESC");
		}
		return ums_userDao.ums_queryUser(userReq);
	}
	
	public UserEvt queryUserById(String id)
	{
		UserReq userReq = new UserReq();
		userReq.setId(id);
		UserEvt userEvt = null;
		List<UserEvt> userList = ums_userDao.ums_queryUser(userReq);
		if (!CommonUtil.isEmpty(userList))
		{
			userEvt = userList.get(0);
		}
		return userEvt;
	}
	
	public int addUser(UserEvt userEvt)
	{
		userEvt.setId(UmsUtil.createUniqueID());
		
		return ums_userDao.ums_addUser(userEvt);
	}
	
	public int updateUser(UserEvt userEvt)
	{
		return ums_userDao.ums_updateUser(userEvt);
	}
	
	public int deleteUser(List<String> ids)
	{
		return ums_userDao.ums_deleteUser(ids);
	}
	
	public int changeStatusUser(String status, List<String> ids)
	{
		int result = 0;
		if (UmsConstant.USER_STATUS_0.equals(status))
		{
			result = ums_userDao.ums_offUser(ids);
		}
		else if (UmsConstant.USER_STATUS_1.equals(status))
		{
			result = ums_userDao.ums_onUser(ids);
		}
		return result;
	}
	
	/**
	 * @return 返回 ums_userDao
	 */
	public UserDao getUms_userDao()
	{
		return ums_userDao;
	}
	
	/**
	 * @param 对ums_userDao进行赋值
	 */
	public void setUms_userDao(UserDao ums_userDao)
	{
		this.ums_userDao = ums_userDao;
	}
	
}
