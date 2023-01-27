package com.yrys.kotlin5group47lesson1.domain.usecase

import com.yrys.kotlin5group47lesson1.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    operator fun invoke() = noteRepository.getAllNotes()

}