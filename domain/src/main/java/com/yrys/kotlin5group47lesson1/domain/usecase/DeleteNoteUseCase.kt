package com.yrys.kotlin5group47lesson1.domain.usecase

import com.yrys.kotlin5group47lesson1.domain.model.Note
import com.yrys.kotlin5group47lesson1.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    infix fun deleteNote(note: Note) = noteRepository.deleteNote(note)

}