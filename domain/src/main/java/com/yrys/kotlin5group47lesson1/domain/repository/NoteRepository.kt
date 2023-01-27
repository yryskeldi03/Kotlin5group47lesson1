package com.yrys.kotlin5group47lesson1.domain.repository

import com.yrys.kotlin5group47lesson1.domain.model.Note
import com.yrys.kotlin5group47lesson1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>

}