package com.android.dutchman.ui.activity.search

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.ActivitySearchBinding
import com.android.dutchman.domain.repository.search.SearchRepository
import com.android.dutchman.presentation.viewmodel.search.SearchViewModel
import com.android.dutchman.presentation.viewmodel.search.SearchViewModelFactory
import com.android.dutchman.util.DataBindingActivity

class SearchActivity : DataBindingActivity<ActivitySearchBinding>(),
    SearchRepository {

    override val layoutId: Int
        get() = R.layout.activity_search

    private val factory = SearchViewModelFactory(this)

    private val viewModel: SearchViewModel by lazy {
        ViewModelProviders.of(this, factory).get(
            SearchViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

    }



}