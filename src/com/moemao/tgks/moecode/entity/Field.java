package com.moemao.tgks.moecode.entity;

public class Field
{
    // 字段名称
    private String fieldName;

    // 字段类型
    private String fieldType;

    // 数据库字段类型
    private String fieldTableType;

    // 配置文件字段类型
    private String fieldJdbcType;

    // 字段长度
    private int fieldLength;

    // 字段注释
    private String fieldComment;

    public String getFieldName()
    {
        return this.fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public String getFieldType()
    {
        return this.fieldType;
    }

    public void setFieldType(String fieldType)
    {
        this.fieldType = fieldType;
    }

    public String getFieldTableType()
    {
        return this.fieldTableType;
    }

    public void setFieldTableType(String fieldTableType)
    {
        this.fieldTableType = fieldTableType;
    }

    public int getFieldLength()
    {
        return this.fieldLength;
    }

    public void setFieldLength(int fieldLength)
    {
        this.fieldLength = fieldLength;
    }

    public String getFieldComment()
    {
        return this.fieldComment;
    }

    public void setFieldComment(String fieldComment)
    {
        this.fieldComment = fieldComment;
    }

    public String getFieldJdbcType()
    {
        return this.fieldJdbcType;
    }

    public void setFieldJdbcType(String fieldJdbcType)
    {
        this.fieldJdbcType = fieldJdbcType;
    }
}
