package com.moemao.tgks.common.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;

import com.moemao.tgks.common.core.spring.ContextUtil;
import com.moemao.tgks.common.init.MessageManager;
import com.moemao.tgks.common.init.SystemConfigDB;
import com.moemao.tgks.common.init.SystemConfigProperties;
import com.moemao.tgks.common.systemlog.entity.SystemLogEvt;
import com.moemao.tgks.common.systemlog.service.SystemLogService;
import com.moemao.tgks.common.ums.user.entity.UserEvt;
import com.opensymphony.xwork2.ActionContext;

public class CommonUtil
{
	private static SystemLogService systemLogService;
    /**
     * COMMON模块唯一标识生成
     * 根据传入的模块标识生成24位的ID
     */
    public static String createUniqueID()
    {
        return IDUtil.createUniqueID(CommonConstant.MODULE_TAG);
    }
    
    public static UserEvt getUserInfoBySession()
    {
    	return (UserEvt) ActionContext.getContext().getSession().get(CommonConstant.USER_INFO);
    }
    
    /**
     * 从系统配置公用组件中获取对应的文字信息
     */
    public static String getConfig(String str)
    {
        String value = "";
        
        if (!StringUtil.isEmpty(str))
        {
            value = SystemConfigProperties.getInstanse().getConfig(str);
        }
        
        return value;
    }
    
    /**
     * 从数据库的系统参数中获取对应的文字信息
     */
    public static String getConfigDB(String str)
    {
        String value = "";
        
        if (!StringUtil.isEmpty(str))
        {
            value = SystemConfigDB.getInstanse().getConfig(str);
        }
        
        return value;
    }
    
    /**
     * 从国际化公用组件中获取对应的文字信息
     */
    public static String getMessage(String str)
    {
        String message = "";
        
        if (!StringUtil.isEmpty(str))
        {
            message = MessageManager.getInstanse().getMessage(str);
        }
        
        return message;
    }
    
    /**
     * 
     * @Title: systemLog
     * @Description: ERP系统日志，用于记录账户动作
     * @param action 名称
     * @param type 类型
     * @param result 操作结果
     * @param desc 详细信息
     * @return void 返回类型
     * @throws
     */
    public static void systemLog(String action, String type, String result, String info)
    {
    	
    	SystemLogEvt systemLogEvt = new SystemLogEvt();
    	UserEvt userEvt = getUserInfoBySession();
    	if (null != userEvt)
    	{
    		systemLogEvt.setUid(userEvt.getId());
    		systemLogEvt.setUsername(userEvt.getUsername());
    	}
    	else
    	{
    		systemLogEvt.setUid("noUID");
    		systemLogEvt.setUsername("noUsername");
    	}
    	systemLogEvt.setAction(action);
    	systemLogEvt.setType(type);
    	systemLogEvt.setResult(result);
    	systemLogEvt.setInfo(info);
    	
    	if (systemLogService == null)
    	{
    		systemLogService = (SystemLogService) ContextUtil.getBean("common_systemLogService");
    	}
    	systemLogService.addSystemLog(systemLogEvt);
    }
    
    /**
     * 如果debug开关开启，则输出debug信息
     */
    public static void debugLog(Log logger, String messageTag, String methodName)
    {
        if (logger.isDebugEnabled())
        {
            logger.debug(CommonUtil.getMessage(messageTag) + "[" + methodName + "]");
        }
    }
    
    /**
     * 行为日志 保存在tomcat下的log目录中
     */
    public static void infoLog(Log logger, String messageTag, String result)
    {
        logger.info(CommonUtil.getMessage(messageTag) + "[" + result + "]");
    }
    
    /**
     * 将用英文逗号分隔的String字符串转化为List<String>
     */
    public static List<String> stringToList(String str)
    {
        List<String> list = new ArrayList<String>();
        String[] strs = str.split(Constant.PUNCTUATION_COMMA);
        
        for (String s : strs)
        {
            list.add(s);
        }
        
        return list;
    }
    
    /**
     * 将List<String>转化为用英文逗号分隔的String字符串
     */
    public static String listToString(List<String> list)
    {
        StringBuffer str = new StringBuffer();
        
        for (String s : list)
        {
            str.append(s).append(Constant.PUNCTUATION_COMMA);
        }
        
        return str.substring(0, str.length() - 1).toString();
    }
    
    public static boolean isEmpty(String str)
    {
        return (null == str || "".equals(str)) ? true : false;
    }
    
    public static boolean isEmpty(Object obj)
    {
        return (null == obj) ? true : false;
    }
    
    public static boolean isEmpty(List<?> list)
    {
        return (null == list || list.size() == 0) ? true : false;
    }
    
    public static boolean isEmpty(Object[] array)
    {
        return (null == array || array.length == 0) ? true : false;
    }
    
    public static boolean isEmpty(Map<?,?> map)
    {
        return (null == map || map.size() == 0) ? true : false;
    }
    
    public static boolean isEmpty(Set<?> set)
    {
        return (null == set || set.size() == 0) ? true : false;
    }
}
