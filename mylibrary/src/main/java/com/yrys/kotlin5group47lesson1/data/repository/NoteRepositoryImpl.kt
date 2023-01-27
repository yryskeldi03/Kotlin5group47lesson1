package com.yrys.kotlin5group47lesson1.data.repository

import com.yrys.kotlin5group47lesson1.data.base.BaseRepository
import com.yrys.kotlin5group47lesson1.data.local.NoteDao
import com.yrys.kotlin5group47lesson1.data.mappers.toNote
import com.yrys.kotlin5group47lesson1.data.mappers.toNoteEntity
import com.yrys.kotlin5group47lesson1.domain.model.Note
import com.yrys.kotlin5group47lesson1.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository, BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        noteDao.createNote(note.toNoteEntity())
    }

    override fun getAllNotes() = doRequest {
        noteDao.getAllNotes().map { it.toNote() }
    }

    override fun editNote(note: Note) = doRequest {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDao.deleteNote(note.toNoteEntity())
    }

}