package com.moemao.tgks.common.frame.menu.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.moemao.tgks.common.core.dao.TGKSDao;
import com.moemao.tgks.common.frame.menu.entity.MenuEvt;
import com.moemao.tgks.common.frame.menu.entity.MenuReq;

/**
 * 
 * @类功能说明：菜单相关Dao
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：太仓零度网络科技有限公司
 * @作者：Ken
 * @创建时间：2012-10-10 下午10:44:56
 * @版本：V1.0
 */
public interface MenuDao extends TGKSDao
{
    public List<MenuEvt> common_queryMenu(MenuReq menuReq) throws DataAccessException;
    
    public int common_addMenu(MenuEvt menuEvt) throws DataAccessException;
    
    public int common_updateMenu(MenuEvt menuEvt) throws DataAccessException;
    
    public int common_deleteMenu(List<String> ids) throws DataAccessException;
    
    public int common_onMenu(List<String> list) throws DataAccessException;
    
    public int common_offMenu(List<String> list) throws DataAccessException;
}
