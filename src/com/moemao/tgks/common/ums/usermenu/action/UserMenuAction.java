package com.moemao.tgks.common.ums.usermenu.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.moemao.tgks.common.core.action.TGKSAction;
import com.moemao.tgks.common.frame.menu.entity.MenuEvt;
import com.moemao.tgks.common.frame.menu.entity.MenuReq;
import com.moemao.tgks.common.frame.menu.service.MenuService;
import com.moemao.tgks.common.frame.tool.FrameConstant;
import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.tool.StringUtil;
import com.moemao.tgks.common.ums.usermenu.entity.UserMenuEvt;
import com.moemao.tgks.common.ums.usermenu.entity.UserMenuReq;
import com.moemao.tgks.common.ums.usermenu.service.UserMenuService;

public class UserMenuAction extends TGKSAction
{
	
	/**
     * 
     */
    private static final long serialVersionUID = -8526114748013380544L;

	private static Log logger = LogFactory.getLog(UserMenuAction.class);
	
	/**
	 * ﻿UserMenu业务接口
	 */
	private UserMenuService ums_userMenuService;
	
	private MenuService common_menuService;
	
	/**
	 * 查询结果集
	 */
	private List<UserMenuEvt> list;
	
	private List<MenuEvt> menuList;
	
	/**
	 * ﻿UserMenuEvt对象
	 */
	private UserMenuEvt userMenuEvt;
	
	/**
	 * ﻿UserMenu查询条件封装对象
	 */
	private UserMenuReq userMenuReq = new UserMenuReq();
	
	public String userMenuManager()
	{
		return SUCCESS;
	}
	
	public String queryUserMenu()
	{
		list = ums_userMenuService.queryUserMenu(userMenuReq);
		return SUCCESS;
	}
	
	public String editUserMenuPage()
	{
		String userId = this.getRequest().getParameter("userId");
		userId = userId.substring(0, userId.length() - 1);
		
		if (!CommonUtil.isEmpty(userId))
		{
			userMenuEvt = ums_userMenuService.queryUserMenuById(userId);
			
			// 如果不存在该用户的菜单记录，则先创建一条
			if (null == userMenuEvt)
			{
				userMenuEvt = new UserMenuEvt();
				userMenuEvt.setUserId(userId);
				userMenuEvt.setMenuId("");
				ums_userMenuService.addUserMenu(userMenuEvt);
			}
		}
		else
		{
			return ERROR;
		}
		
		// 查询出当前启用中的所有菜单
		MenuReq menuReq = new MenuReq();
		menuReq.setSortSql("t.SORT, t.LEVEL");
		menuReq.setStatus(FrameConstant.MENU_STATUS_1);
		menuList = common_menuService.queryMenu(menuReq);
		
		List<String> userMenuList = CommonUtil.stringToList(userMenuEvt.getMenuId());
		
		// 有权限的在展示时临时把status置为2
		for (String menuId : userMenuList)
		{
			for (MenuEvt menuEvt : menuList)
			{
				if (menuId.equals(menuEvt.getId()))
				{
					menuEvt.setStatus("2");
				}
			}
		}
		
		return SUCCESS;
	}
	
	public String editUserMenu()
	{
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "UserMenuAction.updateUserMenu");
		
		String menuId = this.getRequest().getParameter("menuId");
		userMenuEvt.setMenuId(menuId);
		
		int result = 0;
		
		result = ums_userMenuService.updateUserMenu(userMenuEvt);
		
		CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, "UserMenuAction.updateUserMenu");
		
		return SUCCESS;
	}
	
	public String deleteUserMenu()
	{
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN,
		        "UserMenuAction.deleteUserMenu");
		String userIds = this.getRequest().getParameter("userIds");
		int result = ums_userMenuService.deleteUserMenu(CommonUtil
		        .stringToList(userIds));
		CommonUtil.infoLog(logger,
		        CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS,
		        StringUtil.toBeString(result));
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT,
		        "UserMenuAction.deleteUserMenu");
		return SUCCESS;
	}
	
	/**
	 * @return 返回 ums_userMenuService
	 */
	public UserMenuService getUms_userMenuService()
	{
		return ums_userMenuService;
	}
	
	/**
	 * @param 对ums_userMenuService进行赋值
	 */
	public void setUms_userMenuService(UserMenuService ums_userMenuService)
	{
		this.ums_userMenuService = ums_userMenuService;
	}
	
	/**
	 * @return 返回 list
	 */
	public List<UserMenuEvt> getList()
	{
		return list;
	}
	
	/**
	 * @param 对list进行赋值
	 */
	public void setList(List<UserMenuEvt> list)
	{
		this.list = list;
	}
	
	/**
	 * @return 返回 userMenuEvt
	 */
	public UserMenuEvt getUserMenuEvt()
	{
		return userMenuEvt;
	}
	
	/**
	 * @param 对userMenuEvt进行赋值
	 */
	public void setUserMenuEvt(UserMenuEvt userMenuEvt)
	{
		this.userMenuEvt = userMenuEvt;
	}
	
	/**
	 * @return 返回 userMenuReq
	 */
	public UserMenuReq getUserMenuReq()
	{
		return userMenuReq;
	}
	
	/**
	 * @param 对userMenuReq进行赋值
	 */
	public void setUserMenuReq(UserMenuReq userMenuReq)
	{
		this.userMenuReq = userMenuReq;
	}

	public MenuService getCommon_menuService()
    {
    	return common_menuService;
    }

	public void setCommon_menuService(MenuService common_menuService)
    {
    	this.common_menuService = common_menuService;
    }

	public List<MenuEvt> getMenuList()
    {
    	return menuList;
    }

	public void setMenuList(List<MenuEvt> menuList)
    {
    	this.menuList = menuList;
    }
	
}