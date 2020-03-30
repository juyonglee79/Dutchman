package com.android.dutchman.ui.activity.setting.profilechange

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.ActivitySettingProfileChangeBinding
import com.android.dutchman.domain.repository.profilechange.ProfileChangeRepository
import com.android.dutchman.presentation.viewmodel.profilechange.ProfileChangeViewModel
import com.android.dutchman.presentation.viewmodel.profilechange.ProfileChangeViewModelFactory
import com.android.dutchman.util.DataBindingActivity

class ProfileChangeActivity : DataBindingActivity<ActivitySettingProfileChangeBinding>(),
    ProfileChangeRepository {

    override val layoutId: Int
        get() = R.layout.activity_setting_profile_change

    private val factory = ProfileChangeViewModelFactory(this)

    private val viewModel: ProfileChangeViewModel by lazy {
        ViewModelProviders.of(this, factory).get(
            ProfileChangeViewModel::class.java
        )
    }


    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        viewModel.changeProfileSetLiveEvent.observe(this, Observer {
            //프로필 변경
            finish()
        })
        viewModel.goBackLiveEvent.observe(this, Observer { finish() })
        viewModel.setImageLiveEvent.observe(this, Observer { })
    }

}