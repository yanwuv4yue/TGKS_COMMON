package com.moemao.tgks.common.systemlog.entity;

import java.util.Date;

public class SystemLogEvt
{
	/**
	 * 表唯一主键
	 */
	private String id;
	
	/**
	 * 用户ID
	 */
	private String uid;
	
	/**
	 * 用户账号
	 */
	private String username;
	
	/**
	 * 操作类型（0 查询；1 新增；2 修改；3 删除）
	 */
	private String type;
	
	/**
	 * 动作
	 */
	private String action;
	
	/**
	 * 结果
	 */
	private String result;
	
	/**
	 * 详细信息
	 */
	private String info;
	
	/**
	 * IP地址
	 */
	private String ip;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * @return 返回 id
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * @param 对id进行赋值
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	
	/**
	 * @return 返回 uid
	 */
	public String getUid()
	{
		return uid;
	}
	
	/**
	 * @param 对uid进行赋值
	 */
	public void setUid(String uid)
	{
		this.uid = uid;
	}
	
	/**
	 * @return 返回 username
	 */
	public String getUsername()
	{
		return username;
	}
	
	/**
	 * @param 对username进行赋值
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	/**
	 * @return 返回 type
	 */
	public String getType()
	{
		return type;
	}
	
	/**
	 * @param 对type进行赋值
	 */
	public void setType(String type)
	{
		this.type = type;
	}
	
	/**
	 * @return 返回 action
	 */
	public String getAction()
	{
		return action;
	}
	
	/**
	 * @param 对action进行赋值
	 */
	public void setAction(String action)
	{
		this.action = action;
	}
	
	/**
	 * @return 返回 result
	 */
	public String getResult()
	{
		return result;
	}
	
	/**
	 * @param 对result进行赋值
	 */
	public void setResult(String result)
	{
		this.result = result;
	}
	
	public String getInfo()
    {
    	return info;
    }

	public void setInfo(String info)
    {
    	this.info = info;
    }

	public String getIp()
    {
    	return ip;
    }

	public void setIp(String ip)
    {
    	this.ip = ip;
    }

	/**
	 * @return 返回 createTime
	 */
	public Date getCreateTime()
	{
		return createTime;
	}
	
	/**
	 * @param 对createTime进行赋值
	 */
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
	
}