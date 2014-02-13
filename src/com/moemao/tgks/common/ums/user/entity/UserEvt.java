package com.moemao.tgks.common.ums.user.entity;

import java.util.Date;

public class UserEvt
{
	/**
	 * 表唯一主键
	 */
	private String id;
	
	/**
	 * 用户账号
	 */
	private String username;
	
	/**
	 * 用户密码
	 */
	private String password;
	
	/**
	 * 账号状态（0 未启动；1 启用）
	 */
	private String status;
	
	/**
	 * 账号类型（0 普通）
	 */
	private String type;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 用户组ID
	 */
	private String groupId;
	
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
	 * @return 返回 password
	 */
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * @param 对password进行赋值
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 * @return 返回 status
	 */
	public String getStatus()
	{
		return status;
	}
	
	/**
	 * @param 对status进行赋值
	 */
	public void setStatus(String status)
	{
		this.status = status;
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
	 * @return 返回 email
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * @param 对email进行赋值
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * @return 返回 name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @param 对name进行赋值
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * @return 返回 sex
	 */
	public String getSex()
	{
		return sex;
	}
	
	/**
	 * @param 对sex进行赋值
	 */
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	/**
	 * @return 返回 groupId
	 */
	public String getGroupId()
	{
		return groupId;
	}
	
	/**
	 * @param 对groupId进行赋值
	 */
	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
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
