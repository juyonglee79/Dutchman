package com.android.dutchman.ui.fragment.posting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.FragmentMyRoomBinding
import com.android.dutchman.databinding.FragmentPostingBinding
import com.android.dutchman.domain.repository.posting.PostingRepository
import com.android.dutchman.presentation.viewmodel.myroom.MyRoomViewModel
import com.android.dutchman.presentation.viewmodel.posting.PostingViewModel
import com.android.dutchman.presentation.viewmodel.posting.PostingViewModelFactory
import com.android.dutchman.presentation.viewmodel.profileset.ProfileSetViewModel
import com.android.dutchman.ui.adapter.PostingAdapter
import com.android.dutchman.util.DataBindingFragment
import dsm.android.v3.presentation.di.scope.ActivityScope
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_posting.*
import javax.inject.Inject

@ActivityScope
class PostingFragment : DataBindingFragment<FragmentPostingBinding>(), PostingRepository {

    override val layoutId: Int
        get() = R.layout.fragment_posting

    private val factory = PostingViewModelFactory(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!, factory).get(PostingViewModel::class.java)
        binding.vm = viewModel

        viewModel.searchSomethingLiveEvent.observe(this, Observer {  })
        viewModel.contextInputLiveEvent.observe(this, Observer {  })
        viewModel.groupBuyOptionLiveEvent.observe(this, Observer {  })
        viewModel.imgSetOptionLiveEvent.observe(this, Observer {  })
        viewModel.netflixOptionLiveEvent.observe(this, Observer {  })

        viewModel.someoneProfileClickLiveEvent.observe(this, Observer {  })
        viewModel.participatePostingLiveEvent.observe(this, Observer {  })
        viewModel.sharePostingLiveEvent.observe(this, Observer {   })


    }


}