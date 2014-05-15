package com.moemao.tgks.common.frame.note.service.impl;

import java.util.List;

import com.moemao.tgks.common.frame.note.dao.NoteDao;
import com.moemao.tgks.common.frame.note.entity.NoteEvt;
import com.moemao.tgks.common.frame.note.entity.NoteReq;
import com.moemao.tgks.common.frame.note.service.NoteService;
import com.moemao.tgks.common.tool.CommonUtil;

public class NoteServiceImpl implements NoteService
{
	/**
	 * ﻿NoteDao
	 */
	private NoteDao common_noteDao;
	
	public List<NoteEvt> queryNote(NoteReq noteReq)
	{
		if (CommonUtil.isEmpty(noteReq.getSortSql()))
		{
			noteReq.setSortSql(" t.ID DESC");
		}
		return common_noteDao.common_queryNote(noteReq);
	}
	
	public NoteEvt queryNoteById(String id)
	{
		NoteReq noteReq = new NoteReq();
		noteReq.setId(id);
		NoteEvt noteEvt = null;
		List<NoteEvt> noteList = common_noteDao.common_queryNote(noteReq);
		if (!CommonUtil.isEmpty(noteList))
		{
			noteEvt = noteList.get(0);
		}
		return noteEvt;
	}
	
	public int addNote(NoteEvt noteEvt)
	{
		noteEvt.setId(CommonUtil.createUniqueID());
		return common_noteDao.common_addNote(noteEvt);
	}
	
	public int updateNote(NoteEvt noteEvt)
	{
		return common_noteDao.common_updateNote(noteEvt);
	}
	
	public int deleteNote(List<String> ids)
	{
		return common_noteDao.common_deleteNote(ids);
	}
	
	/**
	 * @return 返回 common_noteDao
	 */
	public NoteDao getCommon_noteDao()
	{
		return common_noteDao;
	}
	
	/**
	 * @param 对common_noteDao进行赋值
	 */
	public void setCommon_noteDao(NoteDao common_noteDao)
	{
		this.common_noteDao = common_noteDao;
	}
	
}