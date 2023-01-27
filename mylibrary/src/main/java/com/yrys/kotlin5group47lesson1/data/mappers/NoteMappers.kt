package com.yrys.kotlin5group47lesson1.data.mappers

import com.yrys.kotlin5group47lesson1.data.model.NoteEntity
import com.yrys.kotlin5group47lesson1.domain.model.Note

fun Note.toNoteEntity() = NoteEntity(
    id, title, description, createAt
)

fun NoteEntity.toNote() = Note(
    id, title, description, createAt
)