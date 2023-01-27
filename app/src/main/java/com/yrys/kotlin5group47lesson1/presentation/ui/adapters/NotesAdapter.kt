package com.yrys.kotlin5group47lesson1.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.yrys.kotlin5group47lesson1.databinding.ItemNoteBinding
import com.yrys.kotlin5group47lesson1.domain.model.Note

class NotesAdapter(
    private val onClick: (com.yrys.kotlin5group47lesson1.domain.model.Note) -> Unit
) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    private var list = listOf<com.yrys.kotlin5group47lesson1.domain.model.Note>()

    fun submitList(list: List<com.yrys.kotlin5group47lesson1.domain.model.Note>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class NoteViewHolder(private val binding: ItemNoteBinding) : ViewHolder(binding.root) {

        fun bind(note: com.yrys.kotlin5group47lesson1.domain.model.Note) {
            binding.tvTitle.text = note.title
            binding.tvDescription.text = note.description

            itemView.setOnClickListener {
                onClick.invoke(note)
            }
        }
    }
}