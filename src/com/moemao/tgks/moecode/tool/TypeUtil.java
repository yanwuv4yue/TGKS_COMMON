package com.moemao.tgks.moecode.tool;

public class TypeUtil
{
    public static String getFieldType(String fieldType)
    {
        if (Util.isNotEmpty(fieldType.trim()))
        {
            if ("0".equals(fieldType))
            {
                return "char";
            }
            if ("1".equals(fieldType))
            {
                return "String";
            }
            if ("2".equals(fieldType))
            {
                return "int";
            }
            if ("3".equals(fieldType))
            {
                return "long";
            }
            if ("4".equals(fieldType))
            {
                return "double";
            }
            if ("5".equals(fieldType))
            {
                return "boolean";
            }
            if ("6".equals(fieldType))
            {
                return "Date";
            }
        }

        return "";
    }

    public static String getFieldTableType(String fieldType)
    {
        if (Util.isNotEmpty(fieldType.trim()))
        {
            if ("0".equals(fieldType))
            {
                return "varchar";
            }
            if ("1".equals(fieldType))
            {
                return "varchar";
            }
            if ("2".equals(fieldType))
            {
                return "int";
            }
            if ("3".equals(fieldType))
            {
                return "int";
            }
            if ("4".equals(fieldType))
            {
                return "double";
            }
            if ("5".equals(fieldType))
            {
                return "varchar";
            }
            if ("6".equals(fieldType))
            {
                return "timestamp";
            }
        }

        return "";
    }

    public static String getFieldJdbcType(String fieldType)
    {
        if (Util.isNotEmpty(fieldType.trim()))
        {
            if ("0".equals(fieldType))
            {
                return "VARVHAR";
            }
            if ("1".equals(fieldType))
            {
                return "VARCHAR";
            }
            if ("2".equals(fieldType))
            {
                return "INTEGER";
            }
            if ("3".equals(fieldType))
            {
                return "INTEGER";
            }
            if ("4".equals(fieldType))
            {
                return "INTEGER";
            }
            if ("5".equals(fieldType))
            {
                return "VARCHAR";
            }
            if ("6".equals(fieldType))
            {
                return "VARCHAR";
            }
        }

        return "";
    }
}
