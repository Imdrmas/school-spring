package com.school.service;

import org.springframework.stereotype.Service;

import com.school.modal.Note;

@Service
public interface NoteService {
	
	Note addNote(Note note, long id);
	
	Note editNote(Note note, long id);
	
	Note findNote(long id);
	
	void deleteNote(long id);

}
