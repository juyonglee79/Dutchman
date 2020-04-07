package com.android.dutchman.presentation.viewmodel.showmyfriends

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.showmyfriends.ShowMyFriendsRepository
import com.android.dutchman.util.SingleLiveEvent

class ShowMyFriendsViewModel(val  showMyFriendsRepository: ShowMyFriendsRepository) : ViewModel() {

    var selectedIndex = MutableLiveData<Int?>()

    val btnColorSet = MediatorLiveData<Boolean>().apply {

    }

    val inviteFriendsLiveEvent = SingleLiveEvent<Any>()





    fun inviteFriends() = inviteFriendsLiveEvent.call()

}