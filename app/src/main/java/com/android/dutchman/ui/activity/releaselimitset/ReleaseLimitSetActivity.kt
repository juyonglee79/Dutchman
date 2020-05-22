package com.android.dutchman.ui.activity.releaselimitset

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.ActivityReleaseLimitSetBinding
import com.android.dutchman.domain.repository.releaselimitset.ReleaseLimitSetRepository
import com.android.dutchman.presentation.viewmodel.releaselimitset.ReleaseLimitSetViewModel
import com.android.dutchman.presentation.viewmodel.releaselimitset.ReleaseLimitSetViewModelFactory
import com.android.dutchman.ui.activity.addpost.AddPostActivity
import com.android.dutchman.ui.activity.main.MainActivity
import com.android.dutchman.util.DataBindingActivity
import org.jetbrains.anko.startActivity

class ReleaseLimitSetActivity : DataBindingActivity<ActivityReleaseLimitSetBinding>(),
    ReleaseLimitSetRepository {

    override val layoutId: Int
        get() = R.layout.activity_release_limit_set

    private val factory = ReleaseLimitSetViewModelFactory(this)

    private val viewModel: ReleaseLimitSetViewModel by lazy {
        ViewModelProviders.of(this, factory).get(
            ReleaseLimitSetViewModel::class.java
        )
    }

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        viewModel.selectedLimit.value =
            if (intent.hasExtra("limitSet")) intent.getStringExtra("limitSet") else "전체 공개"

        when (viewModel.selectedLimit.value) {
            "전체 공개" -> viewModel.selectedIndex.value = 1
            "친구만" -> viewModel.selectedIndex.value = 2
            "나만 보기" -> viewModel.selectedIndex.value = 3
        }

        viewModel.cancelLiveEvent.observe(this, Observer {
            //수정 좀 더 효율적으로 하기(이미 입력했던 내용이 변경될 수도 있으니까)
            startActivity<AddPostActivity>()
            finish()
        })
        viewModel.setReleaseLimitLiveEvent.observe(this, Observer {
            //TODO 나중에 수정하기
            startActivity<AddPostActivity>("limitSet" to viewModel.selectedLimit.value)
            finish()
        })
    }


}