package com.android.dutchman.ui.activity.search

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.ActivitySearchBinding
import com.android.dutchman.domain.repository.search.SearchRepository
import com.android.dutchman.presentation.viewmodel.search.SearchViewModel
import com.android.dutchman.presentation.viewmodel.search.SearchViewModelFactory
import com.android.dutchman.ui.adapter.SearchedListAdapter
import com.android.dutchman.ui.adapter.ShowMyFriendsAdapter
import com.android.dutchman.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_show_my_friends.*

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

        AnimationUtils.loadAnimation(applicationContext, R.anim.slide_in_right).let {
            search_input_context_et.startAnimation(it)
        }

        search_list_rv.adapter = SearchedListAdapter(viewModel)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        AnimationUtils.loadAnimation(applicationContext, R.anim.slide_out_left).let {
            search_input_context_et.startAnimation(it)
        }
        overridePendingTransition(0, 0)
        finish()
    }



}