package com.android.dutchman.ui.fragment.notice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.FragmentNoticeBinding
import com.android.dutchman.presentation.viewmodel.notice.NoticeViewModel
import com.android.dutchman.util.DataBindingFragment
import io.reactivex.disposables.CompositeDisposable

class NoticeFragment: DataBindingFragment<FragmentNoticeBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_notice

    val compsite = CompositeDisposable()

    private val fm: FragmentManager? by lazy { fragmentManager }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(NoticeViewModel::class.java)

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        compsite.clear()
    }



}