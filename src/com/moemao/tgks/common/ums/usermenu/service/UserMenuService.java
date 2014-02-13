package com.moemao.tgks.common.ums.usermenu.service;

import java.util.List;

import com.moemao.tgks.common.ums.usermenu.entity.UserMenuEvt;
import com.moemao.tgks.common.ums.usermenu.entity.UserMenuReq;

public interface UserMenuService
{
public List<UserMenuEvt> queryUserMenu(UserMenuReq userMenuReq);

public UserMenuEvt queryUserMenuById(String userId);

public int addUserMenu(UserMenuEvt userMenuEvt);

public int updateUserMenu(UserMenuEvt userMenuEvt);

public int deleteUserMenu(List<String> userIds);

}