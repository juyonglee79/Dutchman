package com.android.dutchman.presentation.viewmodel.invitefriend

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.invitefriend.InviteFriendRepository
import com.android.dutchman.util.SingleLiveEvent

class InviteFriendViewModel(val inviteFriendRepository: InviteFriendRepository) : ViewModel() {

    var btnColorSet = MutableLiveData<Boolean>()

    val showMyFriendsLiveEvent = SingleLiveEvent<Any>()
    val inviteFriendsLiveEvent = SingleLiveEvent<Any>()

    fun showMyFriends() {
        btnColorSet.value = false
        showMyFriendsLiveEvent.call()
    }

    fun inviteFriends() {
        btnColorSet.value = true
        inviteFriendsLiveEvent.call()
    }
}