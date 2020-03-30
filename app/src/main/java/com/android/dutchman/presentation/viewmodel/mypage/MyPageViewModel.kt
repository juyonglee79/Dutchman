package com.android.dutchman.presentation.viewmodel.mypage

import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.mypage.MyPageRepository
import com.android.dutchman.util.SingleLiveEvent

class MyPageViewModel(val myPageRepository: MyPageRepository) : ViewModel() {

    val seeMyRoomLiveEvent = SingleLiveEvent<Any>()
    val seeMyPostingLiveEvent = SingleLiveEvent<Any>()
    val seeMyScrabLiveEvent = SingleLiveEvent<Any>()
    val seeMyFriendLiveEvent = SingleLiveEvent<Any>()
    val seeSettingLiveEvent = SingleLiveEvent<Any>()

    fun seeMyRoom() = seeMyRoomLiveEvent.call()
    fun seeMyPosting() = seeMyPostingLiveEvent.call()
    fun seeMyScrab() = seeMyScrabLiveEvent.call()
    fun seeMyFriends() = seeMyFriendLiveEvent.call()
    fun seeSetting() = seeSettingLiveEvent.call()

}