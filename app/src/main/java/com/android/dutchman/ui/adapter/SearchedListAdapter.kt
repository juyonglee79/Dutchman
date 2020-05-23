package com.android.dutchman.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.dutchman.databinding.ItemSearchListBinding
import com.android.dutchman.presentation.model.SearchedListModel
import com.android.dutchman.presentation.viewmodel.search.SearchViewModel

class SearchedListAdapter(val viewModel: SearchViewModel) : RecyclerView.Adapter<SearchedListAdapter.SearchedListViewHolder>() {
    var item = arrayListOf<SearchedListModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(view: ViewGroup, p1: Int): SearchedListViewHolder {
        val binding = ItemSearchListBinding.inflate(LayoutInflater.from(view.context), view, false)
        return SearchedListViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(viewHolder: SearchedListViewHolder, p1: Int) {
        viewHolder.bind()
    }

    inner class SearchedListViewHolder(val binding: ItemSearchListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.searchedListData = item[adapterPosition]
            binding.vm = viewModel
        }

    }
}