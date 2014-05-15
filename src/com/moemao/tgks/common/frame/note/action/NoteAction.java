package com.moemao.tgks.common.frame.note.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.moemao.tgks.common.core.action.TGKSAction;
import com.moemao.tgks.common.frame.note.entity.NoteEvt;
import com.moemao.tgks.common.frame.note.entity.NoteReq;
import com.moemao.tgks.common.frame.note.service.NoteService;
import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.tool.StringUtil;

public class NoteAction extends TGKSAction
{
	
	/** 
     * @Fields serialVersionUID
     */ 
    private static final long serialVersionUID = 868543337889786829L;

	private static Log logger = LogFactory.getLog(NoteAction.class);
	
	/**
	 * ﻿Note业务接口
	 */
	private NoteService common_noteService;
	
	/**
	 * 查询结果集
	 */
	private List<NoteEvt> list;
	
	/**
	 * ﻿NoteEvt对象
	 */
	private NoteEvt noteEvt;
	
	/**
	 * ﻿Note查询条件封装对象
	 */
	private NoteReq noteReq = new NoteReq();
	
	public String noteManager()
	{
		return SUCCESS;
	}
	
	public String queryNote()
	{
		// 只能查询自己账号的note
		noteReq.setUid(CommonUtil.getUserInfoBySession().getId());
		list = common_noteService.queryNote(noteReq);
		return SUCCESS;
	}
	
	public String editNotePage()
	{
		String id = this.getRequest().getParameter("id");
		if (!CommonUtil.isEmpty(id))
		{
			noteEvt = common_noteService.queryNoteById(id);
		}
		return SUCCESS;
	}
	
	public String editNote()
	{
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "NoteAction.updateNote");
		
		// 先写入当前操作用户的UID
		noteEvt.setUid(CommonUtil.getUserInfoBySession().getId());
		
		int result = 0;
		if (CommonUtil.isEmpty(noteEvt.getId()))
		{
			result = common_noteService.addNote(noteEvt);
		}
		else
		{
			result = common_noteService.updateNote(noteEvt);
		}
		CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, "NoteAction.updateNote");
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: saveLatestNote
	 * @Description: 首页显示的最新记录
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveLatestNote()
	{
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "NoteAction.saveLatestNote");
		
		// 先写入当前操作用户的UID
		noteEvt.setUid(CommonUtil.getUserInfoBySession().getId());
		
		int result = 0;
		
		result = common_noteService.addNote(noteEvt);
		
		CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, "NoteAction.saveLatestNote");
		
		return SUCCESS;
	}
	
	public String getLatestNote()
	{
		// 只能查询自己账号的note
		noteReq.setUid(CommonUtil.getUserInfoBySession().getId());
		list = common_noteService.queryNote(noteReq);
		
		if (list.size() > 0)
		{
			noteEvt = list.get(0);
		}
		
		if (null == noteEvt)
		{
			noteEvt = new NoteEvt();
		}
		return SUCCESS;
	}
	
	public String deleteNote()
	{
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN,
		        "NoteAction.deleteNote");
		String ids = this.getRequest().getParameter("ids");
		int result = common_noteService
		        .deleteNote(CommonUtil.stringToList(ids));
		CommonUtil.infoLog(logger,
		        CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS,
		        StringUtil.toBeString(result));
		CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT,
		        "NoteAction.deleteNote");
		return SUCCESS;
	}
	
	/**
	 * @return 返回 common_noteService
	 */
	public NoteService getCommon_noteService()
	{
		return common_noteService;
	}
	
	/**
	 * @param 对common_noteService进行赋值
	 */
	public void setCommon_noteService(NoteService common_noteService)
	{
		this.common_noteService = common_noteService;
	}
	
	/**
	 * @return 返回 list
	 */
	public List<NoteEvt> getList()
	{
		return list;
	}
	
	/**
	 * @param 对list进行赋值
	 */
	public void setList(List<NoteEvt> list)
	{
		this.list = list;
	}
	
	/**
	 * @return 返回 noteEvt
	 */
	public NoteEvt getNoteEvt()
	{
		return noteEvt;
	}
	
	/**
	 * @param 对noteEvt进行赋值
	 */
	public void setNoteEvt(NoteEvt noteEvt)
	{
		this.noteEvt = noteEvt;
	}
	
	/**
	 * @return 返回 noteReq
	 */
	public NoteReq getNoteReq()
	{
		return noteReq;
	}
	
	/**
	 * @param 对noteReq进行赋值
	 */
	public void setNoteReq(NoteReq noteReq)
	{
		this.noteReq = noteReq;
	}
	
}