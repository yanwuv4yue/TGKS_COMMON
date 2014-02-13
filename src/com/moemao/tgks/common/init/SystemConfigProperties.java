package com.moemao.tgks.common.init;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;

/**
 * 
 * @类功能说明：系统参数
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：太仓零度网络科技有限公司
 * @作者：Ken
 * @创建时间：2012-10-31 下午4:24:20
 * @版本：V1.0
 */
public class SystemConfigProperties
{
    private static SystemConfigProperties instance;

    private static ResourceBundle resourceBundle;

    private static Log logger = LogFactory.getLog(SystemConfigProperties.class);

    private SystemConfigProperties()
    {
        resourceBundle = ResourceBundle.getBundle("config");
    }

    public static SystemConfigProperties getInstanse()
    {
        if (null == instance)
        {
            instance = new SystemConfigProperties();
        }

        return instance;
    }

    public static void init()
    {
        logger.info(CommonUtil.getMessage(CommonConstant.SYSTEM_INFO_INIT_CONFIG_SUCCESS));
    }

    public String getConfig(String key)
    {
        String value = "";

        try
        {
            value = resourceBundle.getString(key);
        }
        catch (MissingResourceException e)
        {
            logger.error(CommonUtil.getMessage(CommonConstant.SYSTEM_INFO_INIT_CONFIG_ERROR_NOTFOUND));

            return "";
        }
        catch (Exception e)
        {
            logger.error(CommonUtil.getMessage(CommonConstant.SYSTEM_INFO_INIT_CONFIG_ERROR_OTHER));

            return "";
        }

        return value;
    }

    public static ResourceBundle getResourceBundle()
    {
        return resourceBundle;
    }
}
