package test;

import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.tool.IDUtil;

public class Test
{
    public static void main(String[] args)
    {
        System.out.println(IDUtil.createUniqueID("A"));
        System.out.println(CommonUtil.createUniqueID());
    }
}
