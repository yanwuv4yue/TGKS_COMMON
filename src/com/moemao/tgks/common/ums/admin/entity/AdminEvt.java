package com.moemao.tgks.common.ums.admin.entity;

import java.util.Date;

public class AdminEvt
{
    private String id;

    private String uid;

    private String level;

    private Date createTime;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUid()
    {
        return this.uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getLevel()
    {
        return this.level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
}
