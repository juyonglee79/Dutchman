package com.android.dutchman.presentation.viewmodel.invitefriend

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.invitefriend.InviteFriendRepository
import com.android.dutchman.util.SingleLiveEvent

class InviteFriendViewModel(val inviteFriendRepository: InviteFriendRepository) : ViewModel() {

    var btnColorSet : Boolean = true

    val showMyFriendsLiveEvent = SingleLiveEvent<Any>()
    val inviteFriendsLiveEvent = SingleLiveEvent<Any>()

    fun showMyFriends() {
        btnColorSet = true
        showMyFriendsLiveEvent.call()
    }

    fun inviteFriends() {
        btnColorSet = false
        inviteFriendsLiveEvent.call()
    }
}