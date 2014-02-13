package com.moemao.tgks.common.frame.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.moemao.tgks.common.core.action.TGKSAction;
import com.moemao.tgks.common.frame.menu.entity.MenuEvt;
import com.moemao.tgks.common.frame.menu.entity.MenuReq;
import com.moemao.tgks.common.frame.menu.service.MenuService;
import com.moemao.tgks.common.frame.tool.FrameConstant;
import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.ums.user.entity.UserEvt;
import com.moemao.tgks.common.ums.user.entity.UserReq;
import com.moemao.tgks.common.ums.user.service.UserService;
import com.moemao.tgks.common.ums.usermenu.entity.UserMenuEvt;
import com.moemao.tgks.common.ums.usermenu.service.UserMenuService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @类功能说明：系统登录入口，进入框架页，加载菜单等信息
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：太仓零度网络科技有限公司
 * @作者：Ken
 * @创建时间：2012-10-21 上午12:42:11
 * @版本：V1.0
 */
public class LoginAction extends TGKSAction
{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1061016555876549781L;
    
    private static Log logger = LogFactory.getLog(LoginAction.class);
    
    /**
     * 菜单列表
     */
    private List<MenuEvt> menuList = new ArrayList<MenuEvt>();
    
    /**
     * 菜单Service
     */
    private MenuService common_menuService;
    
    /**
     * 用户菜单权限
     */
    private UserMenuService ums_userMenuService;
    
    private UserService ums_userService;
    
    /**
     * 登录账户
     */
    private UserEvt userEvt;
    
    private UserReq userReq = new UserReq();
    
    private String message;
    
    public String loginPage()
    {
    	return SUCCESS;
    }
    
    public String login()
    {
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "LoginAction.login");
        
        if (CommonUtil.isEmpty(userReq.getUsername()) || CommonUtil.isEmpty(userReq.getPassword()))
        {
        	message = "密码错误";
    		CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_LOGIN_FAILD, String.format("账号：%s 密码：%s", userReq.getUsername(), userReq.getPassword()));
    		return ERROR;
        }
        
        // 账户登录
        List<UserEvt> userList = ums_userService.queryUser(userReq);
    	
    	if (null != userList && userList.size() > 0)
    	{
    		userEvt = userList.get(0);
            
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put(CommonConstant.USER_INFO, userEvt);
    	}
    	else
    	{
    		message = "密码错误";
    		
    		CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_LOGIN_FAILD, String.format("账号：%s 密码：%s", userReq.getUsername(), userReq.getPassword()));
    		return ERROR;
    	}
        
        // 菜单筛选
        this.userMenu();
        
        CommonUtil.systemLog("common/login.action", CommonConstant.SYSTEMLOG_TYPE_0, CommonConstant.SUCCESS, String.format("账号：%s 登录系统成功", userReq.getUsername()));
		CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_LOGIN_SUCCESS, String.format("账号：%s 密码：%s", userReq.getUsername(), userReq.getPassword()));
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, "LoginAction.login");
        
        return SUCCESS;
    }
    
    private void userMenu()
    {
    	// 查询菜单信息
        MenuReq menuReq = new MenuReq();
        menuReq.setSortSql("t.SORT, t.LEVEL");
        menuReq.setStatus(FrameConstant.MENU_STATUS_1);
        List<MenuEvt> allMenuList = common_menuService.queryMenu(menuReq);
        
        UserMenuEvt userMenuEvt = ums_userMenuService.queryUserMenuById(userEvt.getId());
        List<String> userMenuList = CommonUtil.stringToList(userMenuEvt.getMenuId());
        
        for (MenuEvt menuEvt : allMenuList)
        {
        	for (String userMenuId : userMenuList)
        	{
        		if (userMenuId.equals(menuEvt.getId()))
        		{
        			menuList.add(menuEvt);
        		}
        	}
        }
    }

    public static Log getLogger()
    {
        return logger;
    }

    public static void setLogger(Log logger)
    {
        LoginAction.logger = logger;
    }

    public List<MenuEvt> getMenuList()
    {
        return this.menuList;
    }

    public void setMenuList(List<MenuEvt> menuList)
    {
        this.menuList = menuList;
    }

    public MenuService getCommon_menuService()
    {
        return this.common_menuService;
    }

    public void setCommon_menuService(MenuService common_menuService)
    {
        this.common_menuService = common_menuService;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

	public UserMenuService getUms_userMenuService()
    {
    	return ums_userMenuService;
    }

	public void setUms_userMenuService(UserMenuService ums_userMenuService)
    {
    	this.ums_userMenuService = ums_userMenuService;
    }

	public UserEvt getUserEvt()
    {
    	return userEvt;
    }

	public void setUserEvt(UserEvt userEvt)
    {
    	this.userEvt = userEvt;
    }

	public UserService getUms_userService()
    {
    	return ums_userService;
    }

	public void setUms_userService(UserService ums_userService)
    {
    	this.ums_userService = ums_userService;
    }

	public UserReq getUserReq()
    {
    	return userReq;
    }

	public void setUserReq(UserReq userReq)
    {
    	this.userReq = userReq;
    }

	public String getMessage()
    {
    	return message;
    }

	public void setMessage(String message)
    {
    	this.message = message;
    }
}
