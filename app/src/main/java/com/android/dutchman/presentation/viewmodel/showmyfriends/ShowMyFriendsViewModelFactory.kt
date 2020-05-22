package com.android.dutchman.presentation.viewmodel.showmyfriends

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.showmyfriends.ShowMyFriendsRepository

class ShowMyFriendsViewModelFactory(val showMyFriendsRepository: ShowMyFriendsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return ShowMyFriendsViewModel(showMyFriendsRepository) as T
    }
}