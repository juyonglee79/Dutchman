package com.android.dutchman.presentation.viewmodel.invitefriend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.invitefriend.InviteFriendRepository

class InviteFriendViewModelFactory(val inviteFriendRepository: InviteFriendRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(InviteFriendRepository::class.java).newInstance(inviteFriendRepository)

}