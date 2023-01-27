package com.yrys.kotlin5group47lesson1.presentation.ui.notes

import com.yrys.kotlin5group47lesson1.domain.model.Note
import com.yrys.kotlin5group47lesson1.domain.usecase.DeleteNoteUseCase
import com.yrys.kotlin5group47lesson1.domain.usecase.GetAllNotesUseCase
import com.yrys.kotlin5group47lesson1.presentation.ui.base.BaseViewModel
import com.yrys.kotlin5group47lesson1.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: com.yrys.kotlin5group47lesson1.domain.usecase.GetAllNotesUseCase,
    private val deleteNoteUseCase: com.yrys.kotlin5group47lesson1.domain.usecase.DeleteNoteUseCase
) : BaseViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<com.yrys.kotlin5group47lesson1.domain.model.Note>>>(UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNoteState = _deleteNoteState.asStateFlow()

    fun getAllNotes() {
        getAllNotesUseCase().collectFlow(_getAllNotesState)
    }

    fun deleteNote(note: com.yrys.kotlin5group47lesson1.domain.model.Note) {
        (deleteNoteUseCase deleteNote note).collectFlow(_deleteNoteState)
    }

}