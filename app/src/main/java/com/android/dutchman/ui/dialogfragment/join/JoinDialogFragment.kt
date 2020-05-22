package com.android.dutchman.ui.dialogfragment.join

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.DialogJoinBinding
import com.android.dutchman.domain.repository.join.JoinRepository
import com.android.dutchman.presentation.viewmodel.join.JoinViewModel
import com.android.dutchman.presentation.viewmodel.join.JoinViewModelFactory
import com.android.dutchman.util.DataBindingDialogFragment
import dsm.android.v3.presentation.di.scope.FragmentScope
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

@FragmentScope
class JoinDialogFragment: DataBindingDialogFragment<DialogJoinBinding>(), JoinRepository {

    override val layoutId: Int
        get() = R.layout.dialog_join

    @Inject
    lateinit var factory: JoinViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val viewModel = ViewModelProviders.of(this, factory).get(JoinViewModel::class.java)

        viewModel.cancelDialogLiveEvent.observe(this, Observer { dialog.dismiss() })
        viewModel.enterRoomDialogLiveEvent.observe(this, Observer {
            //TODO 액티비티 인텐트
            activity!!.finish() })
        binding.vm = viewModel
        return rootView
    }

    override fun onStart() {
        super.onStart()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}