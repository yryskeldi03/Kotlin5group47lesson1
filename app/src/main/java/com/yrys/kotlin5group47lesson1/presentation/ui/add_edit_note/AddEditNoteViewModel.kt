package com.yrys.kotlin5group47lesson1.presentation.ui.add_edit_note

import com.yrys.kotlin5group47lesson1.domain.model.Note
import com.yrys.kotlin5group47lesson1.domain.usecase.CreateNoteUseCase
import com.yrys.kotlin5group47lesson1.domain.usecase.EditNoteUseCase
import com.yrys.kotlin5group47lesson1.presentation.ui.base.BaseViewModel
import com.yrys.kotlin5group47lesson1.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val createNoteUseCase: com.yrys.kotlin5group47lesson1.domain.usecase.CreateNoteUseCase,
    private val editNoteUseCase: com.yrys.kotlin5group47lesson1.domain.usecase.EditNoteUseCase
) : BaseViewModel() {

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    fun createNote(note: com.yrys.kotlin5group47lesson1.domain.model.Note) {
        createNoteUseCase(note).collectFlow(_createNoteState)
    }

    fun editNote(note: com.yrys.kotlin5group47lesson1.domain.model.Note) {
        editNoteUseCase(note).collectFlow(_editNoteState)
    }
}