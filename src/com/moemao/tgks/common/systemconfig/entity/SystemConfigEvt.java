package com.moemao.tgks.common.systemconfig.entity;

public class SystemConfigEvt
{
    // 表唯一主键
    private String id;
    
    // 参数标签
    private String tag;
    
    // 参数名称
    private String name;
    
    // 参数值
    private String value;
    
    // 参数类型（1:简短|2:下拉|3:文本|4:单选|5:多选|6:图片）
    private String type;
    
    // 所属模块
    private String module;
    
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

    public String getTag()
    {
        return this.tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getValue()
    {
        return this.value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getModule()
    {
        return this.module;
    }

    public void setModule(String module)
    {
        this.module = module;
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
