package com.moemao.tgks.common.systemconfig.service;

import java.util.List;

import com.moemao.tgks.common.core.service.TGKSService;
import com.moemao.tgks.common.systemconfig.entity.SystemConfigEvt;
import com.moemao.tgks.common.systemconfig.entity.SystemConfigReq;

public interface SystemConfigService extends TGKSService
{
    /**
     * 
     * @函数功能说明：查询系统参数列表
     * @创建者：Ken
     * @创建日期：2012-10-14 下午10:31:15
     * @修改者：
     * @修改日期：
     * @修改内容：
     * @参数：@return
     * @return List<SystemConfigEvt>
     * @throws
     */
    public List<SystemConfigEvt> querySystemConfigList(SystemConfigReq systemConfigReq);
    
    /**
     * 
     * @函数功能说明：根据ID查询系统参数
     * @创建者：Ken
     * @创建日期：2012-11-1 下午4:40:27
     * @修改者：
     * @修改日期：
     * @修改内容：
     * @参数：@param id
     * @参数：@return
     * @return SystemConfigEvt
     * @throws
     */
    public SystemConfigEvt querySystemConfigById(String id);
    
    /**
     * 
     * @函数功能说明：新增系统参数
     * @创建者：Ken
     * @创建日期：2012-10-14 下午10:36:58
     * @修改者：
     * @修改日期：
     * @修改内容：
     * @参数：@return
     * @return int
     * @throws
     */
    public int addSystemConfig(SystemConfigEvt systemConfigEvt);
    
    /**
     * 
     * @函数功能说明：修改系统参数信息
     * @创建者：Ken
     * @创建日期：2012-10-14 下午10:37:11
     * @修改者：
     * @修改日期：
     * @修改内容：
     * @参数：@return
     * @return int
     * @throws
     */
    public int updateSystemConfig(SystemConfigEvt systemConfigEvt);
    
    /**
     * 
     * @函数功能说明：删除系统参数
     * @创建者：Ken
     * @创建日期：2012-10-14 下午10:37:14
     * @修改者：
     * @修改日期：
     * @修改内容：
     * @参数：@return
     * @return int
     * @throws
     */
    public int deleteSystemConfig(List<String> ids);
}
