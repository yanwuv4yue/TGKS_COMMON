package com.moemao.tgks.common.tool;

public class TransUtil
{
	/**
     * 类型转换：String -> int
     * @param str
     * @return
     */
    public static int stringToInt(String str)
    {
    	try
        {
    		if (StringUtil.isNotEmpty(str))
        	{
        		return Integer.parseInt(str);
        	}
        }
        catch (Exception e)
        {
	        return 0;
        }
    	
    	return 0;
    }
    
    /**
     * 类型转换：all -> String
     * @param str
     * @return
     */
    public static String allToString(Object obj)
    {
    	return String.valueOf(obj);
    }
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
	}
	
}
