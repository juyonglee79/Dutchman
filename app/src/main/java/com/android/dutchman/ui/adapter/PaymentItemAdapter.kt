package com.android.dutchman.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.dutchman.databinding.ItemPaymentPeopleBinding
import com.android.dutchman.presentation.model.PaymentModel
import com.android.dutchman.presentation.viewmodel.payment.PaymentViewModel

class PaymentItemAdapter(val viewModel: PaymentViewModel) : RecyclerView.Adapter<PaymentItemAdapter.PaymentViewHolder>() {
    var item = arrayListOf<PaymentModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(view: ViewGroup, p1: Int): PaymentViewHolder{
        val binding = ItemPaymentPeopleBinding.inflate(LayoutInflater.from(view.context), view, false)
        return PaymentViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(viewHolder: PaymentViewHolder, p1: Int) {
        viewHolder.bind()
    }

    inner class PaymentViewHolder(val binding: ItemPaymentPeopleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.paymentData = item[adapterPosition]
            binding.vm = viewModel
        }

    }
}