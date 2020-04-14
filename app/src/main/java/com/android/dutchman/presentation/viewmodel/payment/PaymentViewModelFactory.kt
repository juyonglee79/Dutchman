package com.android.dutchman.presentation.viewmodel.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.payment.PaymentRepository
import com.android.dutchman.presentation.viewmodel.notice.NoticeViewModel

class PaymentViewModelFactory(val paymentRepository: PaymentRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return PaymentViewModel(paymentRepository) as T
    }
}
