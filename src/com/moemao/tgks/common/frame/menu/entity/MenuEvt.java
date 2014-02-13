package com.moemao.tgks.common.frame.menu.entity;

public class MenuEvt
{
    /**
     * 表唯一主键
     */
    private String id;

    /**
     * 上级菜单ID
     */
    private String preId;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 状态（0 未启动；1 启用）
     */
    private String status;

    /**
     * 菜单链接
     */
    private String url;

    /**
     * 菜单级别
     */
    private String level;

    /**
     * 展示顺序
     */
    private String sort;
    
    /**
     * 上级菜单名称
     */
    private String preIdName;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPreId()
    {
        return this.preId;
    }

    public void setPreId(String preId)
    {
        this.preId = preId;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getLevel()
    {
        return this.level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getSort()
    {
        return this.sort;
    }

    public void setSort(String sort)
    {
        this.sort = sort;
    }

    public String getPreIdName()
    {
        return this.preIdName;
    }

    public void setPreIdName(String preIdName)
    {
        this.preIdName = preIdName;
    }
}
