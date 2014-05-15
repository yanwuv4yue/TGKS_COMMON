package com.moemao.tgks.common.frame.note.service;

import java.util.List;

import com.moemao.tgks.common.frame.note.entity.NoteEvt;
import com.moemao.tgks.common.frame.note.entity.NoteReq;

public interface NoteService
{
	public List<NoteEvt> queryNote(NoteReq noteReq);
	
	public NoteEvt queryNoteById(String id);
	
	public int addNote(NoteEvt noteEvt);
	
	public int updateNote(NoteEvt noteEvt);
	
	public int deleteNote(List<String> ids);
	
}