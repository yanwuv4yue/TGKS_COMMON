package com.moemao.tgks.common.ums.usermenu.entity;

public class UserMenuEvt
{
	/**
	 * 账户ID
	 */
	private String userId;
	
	/**
	 * 菜单ID
	 */
	private String menuId;
	
	/**
	 * @return 返回 userId
	 */
	public String getUserId()
	{
		return userId;
	}
	
	/**
	 * @param 对userId进行赋值
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	/**
	 * @return 返回 menuId
	 */
	public String getMenuId()
	{
		return menuId;
	}
	
	/**
	 * @param 对menuId进行赋值
	 */
	public void setMenuId(String menuId)
	{
		this.menuId = menuId;
	}
	
}