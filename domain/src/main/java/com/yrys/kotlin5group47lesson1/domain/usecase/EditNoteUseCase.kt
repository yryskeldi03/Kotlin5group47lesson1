package com.yrys.kotlin5group47lesson1.domain.usecase

import com.yrys.kotlin5group47lesson1.domain.model.Note
import com.yrys.kotlin5group47lesson1.domain.repository.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    operator fun invoke(note: Note) = noteRepository.editNote(note)

}