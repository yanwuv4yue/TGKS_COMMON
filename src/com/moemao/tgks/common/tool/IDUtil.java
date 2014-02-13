package com.moemao.tgks.common.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IDUtil
{
    /**
     * 14位日期标识
     */
    private static final String formatStr = "yyyyMMddHHmmss";

    private static long count = 0;

    /**
     * 根据传入的模块标识生成24位的ID
     * 
     * @param str
     * @return
     */
    public static String createUniqueID(String str)
    {
        if (str.length() != 4)
        {
            str = (str + "XXXX").substring(0, 4);
        }

        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        StringBuffer sb = new StringBuffer();
        sb.append(str.toUpperCase()).append(df.format(new Date()))
                .append(getCount());

        return sb.toString();
    }

    /**
     * 计数器
     * 
     * @return countStr
     */
    private static String getCount()
    {
        if (count > 999999)
        {
            count = 0;
        }

        String str = "00000" + String.valueOf(count);

        count++;

        return str.substring(str.length() - 6);
    }
}
