package com.android.dutchman.presentation.viewmodel.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.search.SearchRepository

class SearchViewModelFactory(val searchRepository: SearchRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return SearchViewModel(searchRepository) as T
    }
}