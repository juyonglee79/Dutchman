package com.android.dutchman.presentation.viewmodel.join

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.join.JoinRepository

class  JoinViewModelFactory (val joinRepository: JoinRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return JoinViewModel(joinRepository) as T
    }
}