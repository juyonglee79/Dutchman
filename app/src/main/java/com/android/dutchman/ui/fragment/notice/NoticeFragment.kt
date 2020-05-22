package com.android.dutchman.ui.fragment.notice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.FragmentNoticeBinding
import com.android.dutchman.domain.repository.notice.NoticeRepository
import com.android.dutchman.presentation.viewmodel.notice.NoticeViewModel
import com.android.dutchman.presentation.viewmodel.notice.NoticeViewModelFactory
import com.android.dutchman.util.DataBindingFragment
import io.reactivex.disposables.CompositeDisposable

class NoticeFragment: DataBindingFragment<FragmentNoticeBinding>(), NoticeRepository {

    override val layoutId: Int
        get() = R.layout.fragment_notice

    val compsite = CompositeDisposable()

    private val factory = NoticeViewModelFactory(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val viewModel = ViewModelProviders.of(this, factory).get(NoticeViewModel::class.java)
        binding.vm = viewModel

        viewModel.goSomeoneProfileLiveEvent.observe(this, Observer {  })
        viewModel.enterInvitedRoomLiveEvent.observe(this, Observer {  })
        viewModel.rejectInvitedRoomLiveEvent.observe(this, Observer {  })
        viewModel.showSettingOfInviteLiveEvent.observe(this, Observer {  })
        viewModel.confirmRequestLiveEvent.observe(this, Observer {  })
        viewModel.rejectConfirmRequestLiveEvent.observe(this, Observer {  })
        viewModel.showSettingOfConfirmLiveEvent.observe(this, Observer {  })
        viewModel.addToFriendLiveEvent.observe(this, Observer {  })
        viewModel.rejectBeingFriendLiveEvent.observe(this, Observer {  })

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        compsite.clear()
    }



}
