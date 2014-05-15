package com.moemao.tgks.common.frame.note.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.moemao.tgks.common.core.dao.TGKSDao;
import com.moemao.tgks.common.frame.note.entity.NoteEvt;
import com.moemao.tgks.common.frame.note.entity.NoteReq;

public interface NoteDao extends TGKSDao
{
	public List<NoteEvt> common_queryNote(NoteReq noteReq)
	        throws DataAccessException;
	
	public int common_addNote(NoteEvt noteEvt) throws DataAccessException;
	
	public int common_updateNote(NoteEvt noteEvt) throws DataAccessException;
	
	public int common_deleteNote(List<String> list) throws DataAccessException;
}