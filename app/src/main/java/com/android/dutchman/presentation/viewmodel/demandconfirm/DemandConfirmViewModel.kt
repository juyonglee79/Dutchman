package com.android.dutchman.presentation.viewmodel.demandconfirm

import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.demandconfirm.DemandConfirmRepository
import com.android.dutchman.util.SingleLiveEvent

class DemandConfirmViewModel(val demandConfirmRepository: DemandConfirmRepository): ViewModel() {

    val sendConfirmAlertLiveEvent = SingleLiveEvent<Any>()
    val cancelDialogLiveEvent = SingleLiveEvent<Any>()

    fun sendConfirmAlert() = sendConfirmAlertLiveEvent.call()
    fun cancelDialog() = cancelDialogLiveEvent.call()
}