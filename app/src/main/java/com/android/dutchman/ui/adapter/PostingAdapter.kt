package com.android.dutchman.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.dutchman.databinding.ItemPostingBinding
import com.android.dutchman.presentation.model.PostingModel
import com.android.dutchman.presentation.viewmodel.posting.PostingViewModel

class PostingAdapter(val viewModel: PostingViewModel) :
    RecyclerView.Adapter<PostingAdapter.PostingViewHolder>() {
    var item = arrayListOf<PostingModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(view: ViewGroup, p1: Int): PostingViewHolder {
        val binding = ItemPostingBinding.inflate(LayoutInflater.from(view.context), view, false)
        return PostingViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(viewHolder: PostingViewHolder, p1: Int) {
        viewHolder.bind()
    }

    inner class PostingViewHolder(val binding: ItemPostingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.postingData = item[adapterPosition]
            binding.vm = viewModel
            binding.index = adapterPosition
        }

    }
}