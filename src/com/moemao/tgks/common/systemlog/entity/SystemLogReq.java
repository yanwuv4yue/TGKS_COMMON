package com.moemao.tgks.common.systemlog.entity;

import java.util.Date;

public class SystemLogReq extends SystemLogEvt
{
	
	/**
	 * 排序字段
	 */
	private String sortSql;
	
	private Date createTimeStart;
	
	private Date createTimeEnd;
	
	/**
	 * @return 返回 排序字段
	 */
	public String getSortSql()
	{
		return this.sortSql;
	}
	
	/**
	 * @param 对排序字段进行赋值
	 */
	public void setSortSql(String sortSql)
	{
		this.sortSql = sortSql;
	}

	public Date getCreateTimeStart()
    {
    	return createTimeStart;
    }

	public void setCreateTimeStart(Date createTimeStart)
    {
    	this.createTimeStart = createTimeStart;
    }

	public Date getCreateTimeEnd()
    {
    	return createTimeEnd;
    }

	public void setCreateTimeEnd(Date createTimeEnd)
    {
    	this.createTimeEnd = createTimeEnd;
    }
	
}