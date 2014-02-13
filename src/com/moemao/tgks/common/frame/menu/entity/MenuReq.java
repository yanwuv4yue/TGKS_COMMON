package com.moemao.tgks.common.frame.menu.entity;

public class MenuReq extends MenuEvt
{
    /**
     * 排序字段
     */
    private String sortSql;

    public String getSortSql()
    {
        return this.sortSql;
    }

    public void setSortSql(String sortSql)
    {
        this.sortSql = sortSql;
    }
}
