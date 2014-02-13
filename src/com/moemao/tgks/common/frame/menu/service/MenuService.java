package com.moemao.tgks.common.frame.menu.service;

import java.util.List;

import com.moemao.tgks.common.core.service.TGKSService;
import com.moemao.tgks.common.frame.menu.entity.MenuEvt;
import com.moemao.tgks.common.frame.menu.entity.MenuReq;

/**
 * 
 * @类功能说明：菜单相关Service
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：太仓零度网络科技有限公司
 * @作者：Ken
 * @创建时间：2012-10-10 下午10:31:12
 * @版本：V1.0
 */
public interface MenuService extends TGKSService
{
    /**
     * 查询菜单列表
     */
    public List<MenuEvt> queryMenu(MenuReq menuReq);
    
    /**
     * 查询菜单列表ById
     */
    public MenuEvt queryMenuById(String id);
    
    /**
     * 新增菜单
     */
    public int addMenu(MenuEvt menuEvt);
    
    /**
     * 修改菜单信息
     */
    public int updateMenu(MenuEvt menuEvt);
    
    /**
     * 删除菜单
     */
    public int deleteMenu(List<String> ids);
    
    /**
     * 变更菜单状态
     */
    public int changeStatusMenu(String status, List<String> ids);
}
