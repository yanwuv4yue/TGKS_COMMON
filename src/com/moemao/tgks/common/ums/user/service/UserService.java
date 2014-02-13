package com.moemao.tgks.common.ums.user.service;

import java.util.List;

import com.moemao.tgks.common.ums.user.entity.UserEvt;
import com.moemao.tgks.common.ums.user.entity.UserReq;

public interface UserService
{
	public List<UserEvt> queryUser(UserReq userReq);
	
	public UserEvt queryUserById(String id);
	
	public int addUser(UserEvt userEvt);
	
	public int updateUser(UserEvt userEvt);
	
	public int deleteUser(List<String> ids);

	public int changeStatusUser(String status, List<String> ids);
}
