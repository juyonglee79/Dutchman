package com.android.dutchman.ui.activity.addpost

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.ActivityAddPostBinding
import com.android.dutchman.domain.repository.addpost.AddPostRepository
import com.android.dutchman.presentation.viewmodel.addpost.AddPostViewModel
import com.android.dutchman.presentation.viewmodel.addpost.AddPostViewModelFactory
import com.android.dutchman.util.DataBindingActivity
import kotlinx.android.synthetic.main.activity_add_post.*

class AddPostActivity : DataBindingActivity<ActivityAddPostBinding>(),
    AddPostRepository {

    override val layoutId: Int
        get() = R.layout.activity_add_post

    private val factory = AddPostViewModelFactory(this)

    private val viewModel: AddPostViewModel by lazy {
        ViewModelProviders.of(this, factory).get(
            AddPostViewModel::class.java
        )
    }

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        viewModel.cancelLiveEvent.observe(this, Observer { finish() })
        viewModel.doPostLiveEvent.observe(this, Observer {  })
        viewModel.setLimitLiveEvent.observe(this, Observer {  })
        viewModel.setNetflixFormLiveEvent.observe(this, Observer {  })
        viewModel.setGroupBuyFormLiveEvent.observe(this, Observer {  })
        viewModel.setImageLiveEvent.observe(this, Observer {  })
        viewModel.inviteFriendLiveEvent.observe(this, Observer {  })

        AnimationUtils.loadAnimation(applicationContext, R.anim.slide_up).let {
            addroom_bottom_layout.startAnimation(it)
        }
    }

}