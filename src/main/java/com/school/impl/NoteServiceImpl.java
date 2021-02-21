package com.school.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.ExamDao;
import com.school.dao.NoteDao;
import com.school.modal.Exam;
import com.school.modal.Note;
import com.school.service.NoteService;

@Component
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private ExamDao examDao;

	@Override
	public Note addNote(Note note, long id) {
		Exam exam = examDao.findById(id).get();
		note.setCreatedAt(new Date());
		exam.addNote(note);
		return noteDao.save(note);
	}

	@Override
	public Note editNote(Note note, long id) {
		Note existNote = noteDao.findById(id).get();
		existNote.setScore(note.getScore());
		existNote.setDescription(note.getDescription());
		return noteDao.save(existNote);
	}

	@Override
	public Note findNote(long id) {
		return noteDao.findById(id).get();
	}

	@Override
	public void deleteNote(long id) {
		noteDao.deleteById(id);
	}
	
	

}
