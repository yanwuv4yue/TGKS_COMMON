package com.moemao.tgks.moecode.entity;

import java.util.List;

public class Module
{
    // 类名
    private String moduleName;
    
    // 模块标识
    private String moduleTag;
    
    // 表名称
    private String moduleTableName;
    
    // 属性字段
    private List<Field> fieldList;
    
    // 查询类字段
    private List<Field> fieldQueryList;
    
    // 表空间名字
    private String tableSpaceName;
    
    // 包路径
    private String packagePach;

    public String getModuleName()
    {
      return this.moduleName;
    }

    public void setModuleName(String moduleName)
    {
      this.moduleName = moduleName;
    }

    public String getModuleTag()
    {
        return this.moduleTag;
    }

    public void setModuleTag(String moduleTag)
    {
        this.moduleTag = moduleTag;
    }

    public String getModuleTableName()
    {
      return this.moduleTableName;
    }

    public void setModuleTableName(String moduleTableName)
    {
      this.moduleTableName = moduleTableName;
    }

    public List<Field> getFieldList()
    {
      return this.fieldList;
    }

    public void setFieldList(List<Field> fieldList)
    {
      this.fieldList = fieldList;
    }

    public String getTableSpaceName()
    {
      return this.tableSpaceName;
    }

    public void setTableSpaceName(String tableSpaceName)
    {
      this.tableSpaceName = tableSpaceName;
    }

    public String getPackagePach()
    {
      return this.packagePach;
    }

    public void setPackagePach(String packagePach)
    {
      this.packagePach = packagePach;
    }

    public List<Field> getFieldQueryList()
    {
      return this.fieldQueryList;
    }

    public void setFieldQueryList(List<Field> fieldQueryList)
    {
      this.fieldQueryList = fieldQueryList;
    }
}
