package com.android.dutchman.ui.fragment.posting

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.FragmentPostingBinding
import com.android.dutchman.domain.repository.posting.PostingRepository
import com.android.dutchman.presentation.viewmodel.posting.PostingViewModel
import com.android.dutchman.presentation.viewmodel.posting.PostingViewModelFactory
import com.android.dutchman.ui.activity.addpost.AddPostActivity
import com.android.dutchman.ui.activity.releaselimitset.ReleaseLimitSetActivity
import com.android.dutchman.ui.activity.room.RoomActivity
import com.android.dutchman.ui.dialogfragment.invitefriend.InviteFriendDialogFragment
import com.android.dutchman.ui.dialogfragment.join.JoinDialogFragment
import com.android.dutchman.util.DataBindingFragment
import dsm.android.v3.presentation.di.scope.ActivityScope
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

@ActivityScope
class PostingFragment : DataBindingFragment<FragmentPostingBinding>(), PostingRepository {

    override val layoutId: Int
        get() = R.layout.fragment_posting

    private val factory = PostingViewModelFactory(this)

    private val fm: FragmentManager? by lazy { fragmentManager }
    private val joinDialogFragment: JoinDialogFragment by  lazy { JoinDialogFragment() }
    private val inviteFriendDialogFragment : InviteFriendDialogFragment by lazy{ InviteFriendDialogFragment() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!, factory).get(PostingViewModel::class.java)

        viewModel.searchSomethingLiveEvent.observe(this, Observer { })
        viewModel.contextInputLiveEvent.observe(this, Observer { startActivity<AddPostActivity>()})
        viewModel.groupBuyOptionLiveEvent.observe(this, Observer { startActivity<RoomActivity>() })
        viewModel.imgSetOptionLiveEvent.observe(this, Observer {  })
        viewModel.netflixOptionLiveEvent.observe(this, Observer {  })
        viewModel.someoneProfileClickLiveEvent.observe(this, Observer {  })
        viewModel.participatePostingLiveEvent.observe(this, Observer { joinDialogFragment.show(fm, "joinRoom") })
        viewModel.sharePostingLiveEvent.observe(this, Observer { })
        binding.vm = viewModel

    }


}