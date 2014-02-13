package com.moemao.tgks.common.module.entity;

/**
 * 
 * @类功能说明：系统模块
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：太仓零度网络科技有限公司
 * @作者：Ken
 * @创建时间：2012-11-1 上午11:30:07
 * @版本：V1.0
 */
public class ModuleEvt
{
    // 表唯一主键
    private String id;
    
    // 模块名
    private String name;
    
    // 展示顺序
    private String sort;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSort()
    {
        return this.sort;
    }

    public void setSort(String sort)
    {
        this.sort = sort;
    }
}
