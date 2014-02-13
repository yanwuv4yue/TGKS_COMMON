package com.moemao.tgks.common.init;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.tool.StringUtil;

/**
 * 
 * @类功能说明：国际化参数初始化
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：太仓零度网络科技有限公司
 * @作者：Ken
 * @创建时间：2012-10-31 下午4:22:19
 * @版本：V1.0
 */
public class MessageManager
{
    private static MessageManager instance;
    
    private static ResourceBundle resourceBundle;
    
    private static String language;
    
    private static String country;
    
    private static Log logger = LogFactory.getLog(MessageManager.class);
    
    private MessageManager()
    {
        if (!StringUtil.allNotEmpty(language, country))
        {
            resourceBundle = ResourceBundle.getBundle("language", Locale.getDefault());
        }
    }
    
    public static MessageManager getInstanse()
    {
        if (null == instance)
        {
            instance = new MessageManager();
        }
        
        return instance;
    }
    
    public static void init()
    {
        logger.info(CommonUtil.getMessage(CommonConstant.SYSTEM_INFO_INIT_I18N_SUCCESS));
    }
    
    public String getMessage(String key)
    {
        String message = "";
        
        try
        {
            message = resourceBundle.getString(key);
        }
        catch (MissingResourceException e)
        {
            logger.error(CommonUtil.getMessage(CommonConstant.SYSTEM_INFO_INIT_I18N_ERROR_NOTFOUND));
            
            return "";
        }
        catch (Exception e)
        {
            logger.error(CommonUtil.getMessage(CommonConstant.SYSTEM_INFO_INIT_I18N_ERROR_OTHER));
            
            return "";
        }
        
        return message;
    }

    public static ResourceBundle getResourceBundle()
    {
        return resourceBundle;
    }
}
