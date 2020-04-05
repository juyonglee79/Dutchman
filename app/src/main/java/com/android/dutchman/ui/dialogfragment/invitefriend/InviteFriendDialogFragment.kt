package com.android.dutchman.ui.dialogfragment.invitefriend

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.DialogInviteFriendsBinding
import com.android.dutchman.domain.repository.join.JoinRepository
import com.android.dutchman.presentation.viewmodel.invitefriend.InviteFriendViewModel
import com.android.dutchman.presentation.viewmodel.invitefriend.InviteFriendViewModelFactory
import com.android.dutchman.util.DataBindingDialogFragment
import dsm.android.v3.presentation.di.scope.FragmentScope
import javax.inject.Inject

@FragmentScope
class InviteFriendDialogFragment: DataBindingDialogFragment<DialogInviteFriendsBinding>(), JoinRepository {

    override val layoutId: Int
        get() = R.layout.dialog_invite_friends

    @Inject
    lateinit var factory: InviteFriendViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val viewModel = ViewModelProviders.of(this, factory).get(InviteFriendViewModel::class.java)

        viewModel.showMyFriendsLiveEvent.observe(this, Observer {  })
        viewModel.inviteFriendsLiveEvent.observe(this, Observer {  })

        binding.vm = viewModel
        return rootView
    }

    override fun onStart() {
        super.onStart()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}