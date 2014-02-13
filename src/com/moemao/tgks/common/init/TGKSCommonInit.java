package com.moemao.tgks.common.init;

import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;

/**
 * 
 * @类功能说明：TGKS初始化启动配置项
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：太仓零度网络科技有限公司
 * @作者：Ken
 * @创建时间：2012-10-31 下午4:22:41
 * @版本：V1.0
 */
public class TGKSCommonInit
{
    public TGKSCommonInit()
    {
        // 国际化组件初始化
        MessageManager.init();
        
        // 系统配置参数初始化
        SystemConfigProperties.init();
        
        this.printVersionInfo();
    }
    
    private void printVersionInfo()
    {
        System.out.println("================================================");
        System.out.println("");
        System.out.println("                                        帝国业务管理平台 " + CommonUtil.getConfig(CommonConstant.TGKS_VERSION));
        System.out.println("");
        System.out.println("================================================");
    }
}
