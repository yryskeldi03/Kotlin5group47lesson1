package com.yrys.kotlin5group47lesson1.presentation.ui.notes

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.yrys.kotlin5group47lesson1.R
import com.yrys.kotlin5group47lesson1.databinding.FragmentNotesBinding
import com.yrys.kotlin5group47lesson1.domain.model.Note
import com.yrys.kotlin5group47lesson1.presentation.extension.showToast
import com.yrys.kotlin5group47lesson1.presentation.ui.adapters.NotesAdapter
import com.yrys.kotlin5group47lesson1.presentation.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : BaseFragment<FragmentNotesBinding, NotesViewModel>(R.layout.fragment_notes) {

    override val binding by viewBinding(FragmentNotesBinding::bind)
    override val viewModel by viewModels<NotesViewModel>()
    private val notesAdapter by lazy { NotesAdapter(this::onItemClick) }

    override fun initialize() {
        with(binding.rvNotes) {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = notesAdapter
        }
    }

    override fun setupRequests() {
        viewModel.getAllNotes()
    }

    override fun setupSubscribers() {
        viewModel.getAllNotesState.collectState(
            onError = {
                showToast(it)
                binding.progress.isVisible = false
            },
            onLoading = {
                binding.progress.isVisible = true
            },
            onSuccess = {
                notesAdapter.submitList(it)
                binding.progress.isVisible = false
            }
        )

        viewModel.deleteNoteState.collectState(
            onError = {
                showToast(it)
                binding.progress.isVisible = false
            },
            onLoading = {
                binding.progress.isVisible = true
            },
            onSuccess = {
                showToast(R.string.deleted_successfully)
            }
        )

    }

    private fun onItemClick(note: com.yrys.kotlin5group47lesson1.domain.model.Note) {
        val bundle = Bundle()
        bundle.putSerializable(ARG_EDIT_NOTE, note)
        findNavController().navigate(R.id.action_notesFragment_to_addEditNoteFragment, bundle)
    }

    override fun setupListeners() {
        binding.fabOpenForm.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_addEditNoteFragment)
        }
    }

    companion object {
        const val ARG_EDIT_NOTE = "edit_note"
    }

}