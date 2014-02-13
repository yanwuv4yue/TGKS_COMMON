package com.moemao.tgks.moecode.tool;

public class Util
{
    public static String trim(String str)
    {
        if (str == null)
        {
            return "";
        }

        return str.trim();
    }

    public static boolean isEmpty(String str)
    {
        return ((str == null) || ("".equals(str)));
    }

    public static boolean isNotEmpty(String str)
    {
        return (!(isEmpty(str)));
    }

    public static String firstUpperCase(String str)
    {
        if (isNotEmpty(str))
        {
            str = str.substring(0, 1).toUpperCase() + str.substring(1);
            return str;
        }

        return "";
    }

    public static String firstLowerCase(String str)
    {
        if (isNotEmpty(str))
        {
            str = str.substring(0, 1).toLowerCase() + str.substring(1);
            return str;
        }

        return "";
    }
    
    public static String firstUpperCaseUTF8(String str)
    {
        if (isNotEmpty(str))
        {
            str = str.substring(1, 2).toUpperCase() + str.substring(2);
            return str;
        }

        return "";
    }

    public static String firstLowerCaseUTF8(String str)
    {
        if (isNotEmpty(str))
        {
            str = str.substring(1, 2).toLowerCase() + str.substring(2);
            return str;
        }

        return "";
    }
    
    public static boolean isEmpty(Object obj)
    {
      return (obj == null);
    }

    public static boolean isNotEmpty(Object obj)
    {
      return (!(isEmpty(obj)));
    }
    
    public static void main(String[] args)
    {
        String str = "Abcd";
        //str = str.substring(0, 1).toLowerCase() + str.substring(1);
        str = Util.firstLowerCase(str);
        System.out.println(str);
    }
}
