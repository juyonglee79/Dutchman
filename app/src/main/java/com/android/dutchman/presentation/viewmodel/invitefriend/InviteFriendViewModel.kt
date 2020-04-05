package com.android.dutchman.presentation.viewmodel.invitefriend

import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.invitefriend.InviteFriendRepository
import com.android.dutchman.util.SingleLiveEvent

class InviteFriendViewModel(val inviteFriendRepository: InviteFriendRepository) : ViewModel() {

    val showMyFriendsLiveEvent = SingleLiveEvent<Any>()
    val inviteFriendsLiveEvent = SingleLiveEvent<Any>()

    fun showMyFriends() = showMyFriendsLiveEvent.call()
    fun inviteFriends() = inviteFriendsLiveEvent.call()

}