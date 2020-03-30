package com.android.dutchman.presentation.viewmodel.posting

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.posting.PostingRepository
import com.android.dutchman.presentation.viewmodel.profileset.ProfileSetViewModel

class PostingViewModelFactory(val postingRepository: PostingRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return PostingViewModel(postingRepository) as T
    }
}
