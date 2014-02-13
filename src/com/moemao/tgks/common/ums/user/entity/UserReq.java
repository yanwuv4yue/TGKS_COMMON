package com.moemao.tgks.common.ums.user.entity;

public class UserReq extends UserEvt
{
	
	/**
	 * 排序字段
	 */
	private String sortSql;
	
	/**
	 * @return 排序字段
	 */
	public String getSortSql()
	{
		return this.sortSql;
	}
	
	/**
	 * @param 排序字段
	 */
	public void setSortSql(String sortSql)
	{
		this.sortSql = sortSql;
	}
	
}
