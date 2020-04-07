package com.android.dutchman.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.dutchman.databinding.ItemShowMyFriendsListBinding
import com.android.dutchman.presentation.model.MyFriendsModel
import com.android.dutchman.presentation.viewmodel.showmyfriends.ShowMyFriendsViewModel

class ShowMyFriendsAdapter(val viewModel: ShowMyFriendsViewModel) : RecyclerView.Adapter<ShowMyFriendsAdapter.MyFriendsViewHolder>() {
    var item = arrayListOf<MyFriendsModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(view: ViewGroup, p1: Int): MyFriendsViewHolder {
        val binding = ItemShowMyFriendsListBinding.inflate(LayoutInflater.from(view.context), view, false)
        return MyFriendsViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(viewHolder: MyFriendsViewHolder, p1: Int) {
        viewHolder.bind()
    }

    inner class MyFriendsViewHolder(val binding: ItemShowMyFriendsListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.myFriendsData = item[adapterPosition]
            binding.vm = viewModel
        }

    }
}