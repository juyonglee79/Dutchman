package com.android.dutchman.presentation.viewmodel.profileset

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.profileset.ProfileSetRepository

class ProfileSetViewModelFactory(val profileSetRepository: ProfileSetRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return ProfileSetViewModel(profileSetRepository) as T
    }
}
