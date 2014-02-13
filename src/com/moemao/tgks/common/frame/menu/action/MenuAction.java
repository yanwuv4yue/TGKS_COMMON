package com.moemao.tgks.common.frame.menu.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.moemao.tgks.common.core.action.TGKSAction;
import com.moemao.tgks.common.frame.menu.entity.MenuEvt;
import com.moemao.tgks.common.frame.menu.entity.MenuReq;
import com.moemao.tgks.common.frame.menu.service.MenuService;
import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.tool.StringUtil;

/**
 * 
 * @类功能说明：菜单相关action
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：太仓零度网络科技有限公司
 * @作者：Ken
 * @创建时间：2012-10-10 下午10:44:13
 * @版本：V1.0
 */
public class MenuAction extends TGKSAction
{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -678202286485752594L;
    
    private static Log logger = LogFactory.getLog(MenuAction.class);

    private MenuReq menuReq = new MenuReq();

    private MenuEvt menuEvt;

    private List<MenuEvt> list;
    
    private List<MenuEvt> moduleList;
    
    private MenuService common_menuService;
    
    public String menuManager()
    {
    	// 查询一级菜单
        MenuReq menu = new MenuReq();
        menu.setLevel("1");
        moduleList = common_menuService.queryMenu(menu);
        return SUCCESS;
    }
    
    public String queryMenu()
    {
        list = common_menuService.queryMenu(menuReq);
        
        return SUCCESS;
    }
    
    public String queryMenuById()
    {
        String id = this.getRequest().getParameter("id");
        menuEvt = common_menuService.queryMenuById(id);
        return SUCCESS;
    }
    
    /**
     * 
     * @函数功能说明：更新菜单信息界面
     * @创建者：Ken
     * @创建日期：2012-11-2 下午3:25:44
     */
    public String editMenuPage()
    {
        String id = this.getRequest().getParameter("id");
        if (!CommonUtil.isEmpty(id))
        {
            menuEvt = common_menuService.queryMenuById(id);
            
        }
        MenuReq menu = new MenuReq();
        menu.setLevel("1");
        moduleList = common_menuService.queryMenu(menu);
        return SUCCESS;
    }
    
    public String editMenu()
    {
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "MenuAction.updateMenu");
        int result = 0;
        if (CommonUtil.isEmpty(menuEvt.getId()))
        {
            result = common_menuService.addMenu(menuEvt);
        }
        else
        {
            result = common_menuService.updateMenu(menuEvt);
        }
        CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));
        
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, "MenuAction.updateMenu");
        
        return SUCCESS;
    }
    
    public String deleteMenu()
    {
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "MenuAction.deleteMenu");
        
        String ids = this.getRequest().getParameter("ids");
        int result = common_menuService.deleteMenu(CommonUtil.stringToList(ids));
        CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));
        
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, "MenuAction.deleteMenu");
        
        return SUCCESS;
    }
    
    /**
     * 
     * @函数功能说明：启用/停用菜单
     * @创建者：Ken
     * @创建日期：2012-11-8 下午2:18:05
     * @return String
     * @throws
     */
    public String changeStatusMenu()
    {
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "MenuAction.changeStatusMenu");
        
        String ids = this.getRequest().getParameter("ids");
        String status = this.getRequest().getParameter("status");
        int result = common_menuService.changeStatusMenu(status, CommonUtil.stringToList(ids));
        CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));
        
        CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, "MenuAction.changeStatusMenu");
        
        return SUCCESS;
    }
    
    public static Log getLogger()
    {
        return logger;
    }

    public static void setLogger(Log logger)
    {
        MenuAction.logger = logger;
    }

    public MenuReq getMenuReq()
    {
        return this.menuReq;
    }

    public void setMenuReq(MenuReq menuReq)
    {
        this.menuReq = menuReq;
    }

    public MenuEvt getMenuEvt()
    {
        return this.menuEvt;
    }

    public void setMenuEvt(MenuEvt menuEvt)
    {
        this.menuEvt = menuEvt;
    }

    public List<MenuEvt> getList()
    {
        return this.list;
    }

    public void setList(List<MenuEvt> list)
    {
        this.list = list;
    }

    public List<MenuEvt> getModuleList()
    {
        return this.moduleList;
    }

    public void setModuleList(List<MenuEvt> moduleList)
    {
        this.moduleList = moduleList;
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
}
