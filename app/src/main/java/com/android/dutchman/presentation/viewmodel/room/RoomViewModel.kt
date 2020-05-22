package com.android.dutchman.presentation.viewmodel.room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.room.RoomRepository
import com.android.dutchman.util.SingleLiveEvent

class RoomViewModel(val roomRepository: RoomRepository) : ViewModel() {

    val paymentBtnColorSet = MutableLiveData<Boolean>()
    val chatBtnColorSet = MutableLiveData<Boolean>()

    val showSettingLiveEvent = SingleLiveEvent<Any>()
    val showChatLiveEvent = SingleLiveEvent<Any>()
    val showPaymentLiveEvent = SingleLiveEvent<Any>()

    fun showSetting() = showSettingLiveEvent.call()
    fun showChat() {
        chatBtnColorSet.value = false
        paymentBtnColorSet.value = true
        showChatLiveEvent.call()
    }

    fun showPayment() {
        chatBtnColorSet.value = true
        paymentBtnColorSet.value = false
        showPaymentLiveEvent.call()
    }



}