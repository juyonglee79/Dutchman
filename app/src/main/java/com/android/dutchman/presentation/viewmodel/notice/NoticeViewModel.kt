package com.android.dutchman.presentation.viewmodel.notice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.notice.NoticeRepository
import com.android.dutchman.util.SingleLiveEvent
import java.text.SimpleDateFormat
import java.util.*

class NoticeViewModel(val noticeRepository: NoticeRepository) : ViewModel() {

    val goSomeoneProfileLiveEvent =  SingleLiveEvent<Any>()
    val enterInvitedRoomLiveEvent =  SingleLiveEvent<Any>()
    val rejectInvitedRoomLiveEvent =  SingleLiveEvent<Any>()
    val showSettingOfInviteLiveEvent =  SingleLiveEvent<Any>()
    val confirmRequestLiveEvent =  SingleLiveEvent<Any>()
    val rejectConfirmRequestLiveEvent =  SingleLiveEvent<Any>()
    val showSettingOfConfirmLiveEvent =  SingleLiveEvent<Any>()
    val addToFriendLiveEvent =  SingleLiveEvent<Any>()
    val rejectBeingFriendLiveEvent =  SingleLiveEvent<Any>()

    fun goSomeoneProfile() = goSomeoneProfileLiveEvent.call()
    fun enterInvitedRoom() = enterInvitedRoomLiveEvent.call()
    fun rejectInvitedRoom() = rejectInvitedRoomLiveEvent.call()
    fun showSettingOfInvite() = showSettingOfInviteLiveEvent.call()
    fun confirmRequest() = confirmRequestLiveEvent.call()
    fun rejectConfirmRequest() = rejectConfirmRequestLiveEvent.call()
    fun showSettingOfConfirm() = showSettingOfConfirmLiveEvent.call()
    fun addToFriend() = addToFriendLiveEvent.call()
    fun rejectBeingFriend() = rejectBeingFriendLiveEvent.call()

}