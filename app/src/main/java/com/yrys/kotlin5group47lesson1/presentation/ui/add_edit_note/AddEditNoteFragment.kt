package com.yrys.kotlin5group47lesson1.presentation.ui.add_edit_note

import android.os.Build
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.yrys.kotlin5group47lesson1.R
import com.yrys.kotlin5group47lesson1.databinding.FragmentAddEditNoteBinding
import com.yrys.kotlin5group47lesson1.domain.model.Note
import com.yrys.kotlin5group47lesson1.presentation.ui.base.BaseFragment
import com.yrys.kotlin5group47lesson1.presentation.ui.notes.NotesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditNoteFragment :
    BaseFragment<FragmentAddEditNoteBinding, AddEditNoteViewModel>(R.layout.fragment_add_edit_note) {

    // jdkfjdk
    private val b = 1
    override val viewModel by viewModels<AddEditNoteViewModel>()
    private val y = 3
    override val binding by viewBinding(FragmentAddEditNoteBinding::bind)
    private val a = 0
    private var note: Note? = null

    override fun initialize() {
        note = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable(
                NotesFragment.ARG_EDIT_NOTE,
                Note::class.java
            )
        } else {
            arguments?.getSerializable(NotesFragment.ARG_EDIT_NOTE) as Note?
        }
        if (note != null) {
            binding.etTitle.setText(note!!.title)
            binding.etDescription.setText(note!!.description)
        }
    }

    override fun setupListeners() {
        binding.btnSave.setOnClickListener {
            if (note == null) {
                viewModel.createNote(
                    Note(
                        title = binding.etTitle.text.toString(),
                        description = binding.etDescription.text.toString(),
                        createAt = System.currentTimeMillis()
                    )
                )
            } else {
                viewModel.editNote(
                    Note(
                        id = note!!.id,
                        title = binding.etTitle.text.toString(),
                        description = binding.etDescription.text.toString(),
                        createAt = System.currentTimeMillis()
                    )
                )
            }
        }
    }

    override fun setupSubscribers() {
        viewModel.createNoteState.collectState(
            onLoading = {
            },
            onError = {
            },
            onSuccess = {
                findNavController().navigateUp()
            }
        )

        viewModel.editNoteState.collectState(
            onLoading = {
            },
            onError = {
            },
            onSuccess = {
                findNavController().navigateUp()
            }
        )

    }

}