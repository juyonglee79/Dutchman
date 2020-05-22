package com.android.dutchman.ui.dialogfragment.demandconfirm

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.DialogDemandConfirmBinding
import com.android.dutchman.domain.repository.demandconfirm.DemandConfirmRepository
import com.android.dutchman.presentation.viewmodel.demandconfirm.DemandConfirmViewModel
import com.android.dutchman.presentation.viewmodel.demandconfirm.DemandConfirmViewModelFactory
import com.android.dutchman.util.DataBindingDialogFragment
import dsm.android.v3.presentation.di.scope.FragmentScope
import javax.inject.Inject

@FragmentScope
class DemandConfirmDialogFragment: DataBindingDialogFragment<DialogDemandConfirmBinding>(), DemandConfirmRepository {

    override val layoutId: Int
        get() = R.layout.dialog_demand_confirm

    @Inject
    lateinit var factory: DemandConfirmViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val viewModel = ViewModelProviders.of(this, factory).get(DemandConfirmViewModel::class.java)

        viewModel.cancelDialogLiveEvent.observe(this, Observer { dialog.dismiss() })
        viewModel.sendConfirmAlertLiveEvent.observe(this, Observer {
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