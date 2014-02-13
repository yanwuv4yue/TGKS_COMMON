package com.moemao.tgks.common.ums.tool;

import com.moemao.tgks.common.tool.IDUtil;

public class UmsUtil
{
    /**
     * UMS模块唯一标识生成
     * 根据传入的模块标识生成24位的ID
     * 
     * @return
     */
    public static String createUniqueID()
    {
        return IDUtil.createUniqueID(UmsConstant.MODULE_TAG);
    }
}
