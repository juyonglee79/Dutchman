package com.android.dutchman.presentation.viewmodel.profilechange

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.profilechange.ProfileChangeRepository

class ProfileChangeViewModelFactory (val profileChangeRepository: ProfileChangeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return ProfileChangeViewModel(profileChangeRepository) as T
    }
}
