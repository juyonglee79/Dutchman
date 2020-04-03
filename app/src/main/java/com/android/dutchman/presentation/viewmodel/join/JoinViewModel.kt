package com.android.dutchman.presentation.viewmodel.join

import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.join.JoinRepository
import com.android.dutchman.util.SingleLiveEvent

class JoinViewModel(val joinRepository: JoinRepository) : ViewModel() {

    val enterRoomDialogLiveEvent = SingleLiveEvent<Any>()
    val cancelDialogLiveEvent = SingleLiveEvent<Any>()

    fun enterRoomDialog() = enterRoomDialogLiveEvent.call()
    fun cancelDialog() = cancelDialogLiveEvent.call()
}