package com.android.dutchman.presentation.viewmodel.releaselimitset

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.releaselimitset.ReleaseLimitSetRepository

class ReleaseLimitSetViewModelFactory(val releaseLimitSetRepository: ReleaseLimitSetRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return ReleaseLimitSetViewModel(releaseLimitSetRepository) as T
    }
}
