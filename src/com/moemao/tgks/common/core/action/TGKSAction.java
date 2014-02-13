package com.moemao.tgks.common.core.action;

import com.moemao.tgks.common.core.tool.Constant;
import com.opensymphony.xwork2.Action;

public class TGKSAction extends TGKSActionSupport implements Action
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3508956897960552011L;

    /**
     * 当前页码
     */
    protected int currentPage = Constant.CURRENT_PAGE_DEFAULT;

    /**
     * 页码列表展示记录数
     */
    protected int pageSize = Constant.PAGE_SIZE_DEFAULT;

    /**
     * 本次查询总记录数
     */
    protected int totalRecord;

    /**
     * 本次查询总页数
     */
    protected int totalPage;

    /**
     * 页面返回信息
     */
    protected String message;

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getTotalRecord()
    {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord)
    {
        this.totalRecord = totalRecord;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getTotalPage()
    {
        if (totalRecord % pageSize != 0)
        {
            totalPage = totalRecord / pageSize + 1;
        }
        else
        {
            totalPage = totalRecord / pageSize;
        }

        if (totalPage < 1)
        {
            totalPage = 1;
        }

        return totalPage;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String execute() throws Exception
    {
        return null;
    }
}
