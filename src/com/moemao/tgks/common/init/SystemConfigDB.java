package com.moemao.tgks.common.init;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.moemao.tgks.common.systemconfig.service.SystemConfigService;
import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;

public class SystemConfigDB
{
    private static SystemConfigDB instance;
    
    private static Map<String, String> map = new HashMap<String, String>();

    private static Log logger = LogFactory.getLog(SystemConfigDB.class);
    
    private SystemConfigService common_systemConfigService;

    private SystemConfigDB()
    {
        if (CommonUtil.isEmpty(map))
        {
            map = new HashMap<String, String>();
        }
    }

    public static SystemConfigDB getInstanse()
    {
        if (null == instance)
        {
            instance = new SystemConfigDB();
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
            value = map.get(key);
            
            if (CommonUtil.isEmpty(value))
            {
                value = common_systemConfigService.querySystemConfigById(key).getValue();
                map.put(key, value);
            }
        }
        catch (DataAccessException e)
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

    public static Map<String, String> getMap()
    {
        return map;
    }

    public static void setMap(Map<String, String> map)
    {
        SystemConfigDB.map = map;
    }

    public static Log getLogger()
    {
        return logger;
    }

    public static void setLogger(Log logger)
    {
        SystemConfigDB.logger = logger;
    }

    public SystemConfigService getCommon_systemConfigService()
    {
        return this.common_systemConfigService;
    }

    public void setCommon_systemConfigService(
            SystemConfigService common_systemConfigService)
    {
        this.common_systemConfigService = common_systemConfigService;
    }
}
