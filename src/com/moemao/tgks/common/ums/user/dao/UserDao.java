package com.moemao.tgks.common.ums.user.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.moemao.tgks.common.core.dao.TGKSDao;
import com.moemao.tgks.common.ums.user.entity.UserEvt;
import com.moemao.tgks.common.ums.user.entity.UserReq;

public interface UserDao extends TGKSDao
{
	public List<UserEvt> ums_queryUser(UserReq userReq) throws DataAccessException;
	
	public int ums_addUser(UserEvt userEvt) throws DataAccessException;
	
	public int ums_updateUser(UserEvt userEvt) throws DataAccessException;
	
	public int ums_deleteUser(List<String> list) throws DataAccessException;
	
	public int ums_onUser(List<String> ids) throws DataAccessException;
	
	public int ums_offUser(List<String> ids) throws DataAccessException;
}
