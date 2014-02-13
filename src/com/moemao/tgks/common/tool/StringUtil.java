package com.moemao.tgks.common.tool;

public class StringUtil
{
    /**
     * 判断字符串是否为空 null or ""
     * @param str
     * @return 空返回true
     */
    public static boolean isEmpty(String str)
    {
        return (null == str || "".equals(str)) ? true : false;
    }

    /**
     * 判断字符串是否不为空 null or ""
     * @param str
     * @return 空返回true
     */
    public static boolean isNotEmpty(String str)
    {
      return (!(isEmpty(str)));
    }
    
    /**
     * 判断字符串参数是不是都非空
     * @param str
     * @return 都非空时返回true
     */
    public static boolean allNotEmpty(String... str)
    {
        for (String s : str)
        {
            if (isEmpty(s))
            {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * 强制转换为String
     * @参数：@param obj
     * @参数：@return
     * @return String
     */
    public static String toBeString(Object obj)
    {
        return String.valueOf(obj);
    }
    
    /**
     * 取出String两边的空格
     * @参数：@param str
     * @参数：@return
     * @return String
     * @throws
     */
    public static String trim(String str)
    {
      if (str == null)
      {
        return "";
      }

      return str.trim();
    }

    /**
     * 首字母大写
     * @参数：@param str
     * @参数：@return
     * @return String
     * @throws
     */
    public static String firstUpperCase(String str)
    {
      if (isNotEmpty(str))
      {
        str = str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
        return str;
      }

      return "";
    }

    /**
     * 首字母小写
     * @参数：@param str
     * @参数：@return
     * @return String
     * @throws
     */
    public static String firstLowerCase(String str)
    {
      if (isNotEmpty(str))
      {
        str = str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toLowerCase());
        return str;
      }

      return "";
    }
    
    public static void main(String[] args)
    {
        System.out.println(firstLowerCase("SampleEvt"));
    }
}
