package com.moemao.tgks.common.frame.note.entity;

import java.util.Date;

public class NoteEvt
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
	 * 记录内容
	 */
	private String content;
	
	/**
	 * 优先级
	 */
	private String level;
	
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
	 * @return 返回 content
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * @param 对content进行赋值
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	
	/**
	 * @return 返回 level
	 */
	public String getLevel()
	{
		return level;
	}
	
	/**
	 * @param 对level进行赋值
	 */
	public void setLevel(String level)
	{
		this.level = level;
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