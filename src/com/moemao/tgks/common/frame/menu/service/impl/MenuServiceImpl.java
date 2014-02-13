package com.moemao.tgks.common.frame.menu.service.impl;

import java.util.List;

import com.moemao.tgks.common.frame.menu.dao.MenuDao;
import com.moemao.tgks.common.frame.menu.entity.MenuEvt;
import com.moemao.tgks.common.frame.menu.entity.MenuReq;
import com.moemao.tgks.common.frame.menu.service.MenuService;
import com.moemao.tgks.common.frame.tool.FrameConstant;
import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.tool.TransUtil;

/**
 * 
 * @类功能说明：菜单功能相关实现类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：太仓零度网络科技有限公司
 * @作者：Ken
 * @创建时间：2012-10-10 下午10:32:48
 * @版本：V1.0
 */
public class MenuServiceImpl implements MenuService
{
    private MenuDao common_menuDao;

    /**
     * 查询菜单列表
     */
    public List<MenuEvt> queryMenu(MenuReq menuReq)
    {
        if (CommonUtil.isEmpty(menuReq.getSortSql()))
        {
            menuReq.setSortSql(" t.ID DESC");
        }
        
        List<MenuEvt> list = common_menuDao.common_queryMenu(menuReq);
        
        return this.dealSort(list);
    }
    
    /**
     * 查询菜单列表ById
     */
    public MenuEvt queryMenuById(String id)
    {
        MenuReq menuReq = new MenuReq();
        menuReq.setId(id);
        List<MenuEvt> list = common_menuDao.common_queryMenu(menuReq);
        
        // 查询时需要把排序算法扣除 一级x100 | 二级+一级
        list = this.dealSort(list);
        
        if (CommonUtil.isEmpty(list))
        {
            return null;
        }
        
        return list.get(0);
    }

    public int addMenu(MenuEvt menuEvt)
    {
        menuEvt.setId(CommonUtil.createUniqueID());
        
        if ("0".equals(menuEvt.getPreId()))
        {
            menuEvt.setUrl("#");
            menuEvt.setLevel(FrameConstant.MENU_LEVEL_1);
            
            // 一级菜单的排序号码X100
            menuEvt.setSort(TransUtil.allToString(TransUtil.stringToInt(menuEvt.getSort()) * 100));
        }
        else
        {
            menuEvt.setLevel(FrameConstant.MENU_LEVEL_2);
            
            MenuReq menuReq = new MenuReq();
            menuReq.setId(menuEvt.getPreId());
            List<MenuEvt> list = this.queryMenu(menuReq);
            if (CommonUtil.isEmpty(list))
            {
                
            }
            else
            {
            	// 二级菜单的排序需要加上一级菜单的排序
                menuEvt.setSort(TransUtil.allToString(TransUtil.stringToInt(list.get(0).getSort()) * 100 + TransUtil.stringToInt(menuEvt.getSort())));
            }
        }
        
        menuEvt.setStatus(FrameConstant.MENU_STATUS_0);
        
        return common_menuDao.common_addMenu(menuEvt);
    }

    public int updateMenu(MenuEvt menuEvt)
    {
        if ("0".equals(menuEvt.getPreId()))
        {
        	// 上级菜单ID为0时表示该菜单为一级菜单，无url属性
            menuEvt.setUrl("#");
            menuEvt.setLevel(FrameConstant.MENU_LEVEL_1);
            
            // 一级菜单的排序号码X100
            menuEvt.setSort(TransUtil.allToString(TransUtil.stringToInt(menuEvt.getSort()) * 100));
        }
        else
        {
            menuEvt.setLevel(FrameConstant.MENU_LEVEL_2);
            
            MenuReq menuReq = new MenuReq();
            menuReq.setId(menuEvt.getPreId());
            List<MenuEvt> list = this.queryMenu(menuReq);
            if (CommonUtil.isEmpty(list))
            {
                
            }
            else
            {
            	// 二级菜单的排序需要加上一级菜单的排序
            	menuEvt.setSort(TransUtil.allToString(TransUtil.stringToInt(list.get(0).getSort()) * 100 + TransUtil.stringToInt(menuEvt.getSort())));
            }
        }
        return common_menuDao.common_updateMenu(menuEvt);
    }

    public int deleteMenu(List<String> ids)
    {
        return common_menuDao.common_deleteMenu(ids);
    }
    
    public int changeStatusMenu(String status, List<String> ids)
    {
        if (FrameConstant.MENU_STATUS_1.equals(status))
        {
            return common_menuDao.common_onMenu(ids);
        }
        else
        {
            return common_menuDao.common_offMenu(ids);
        }
    }
    
    /**
     * 处理页面的排序显示
     * @param list
     * @return
     */
    private List<MenuEvt> dealSort(List<MenuEvt> list)
    {
    	for (MenuEvt menuEvt : list)
    	{
    		if (FrameConstant.MENU_LEVEL_1.equals(menuEvt.getLevel()))
    		{
            	menuEvt.setSort(TransUtil.allToString(TransUtil.stringToInt(menuEvt.getSort())/100));
    		}
            else if (FrameConstant.MENU_LEVEL_2.equals(menuEvt.getLevel()))
            {
            	menuEvt.setSort(TransUtil.allToString(TransUtil.stringToInt(menuEvt.getSort())%100));
            }
    	}
    	
    	return list;
    }

    public MenuDao getCommon_menuDao()
    {
        return this.common_menuDao;
    }

    public void setCommon_menuDao(MenuDao common_menuDao)
    {
        this.common_menuDao = common_menuDao;
    }
}
