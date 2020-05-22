package com.android.dutchman.presentation.viewmodel.addpost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.addpost.AddPostRepository

class AddPostViewModelFactory(val addPostRepository: AddPostRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return AddPostViewModel(addPostRepository) as T
    }
}
