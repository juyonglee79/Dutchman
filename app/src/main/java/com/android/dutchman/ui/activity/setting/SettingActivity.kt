package com.android.dutchman.ui.activity.setting

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.ActivitySettingBinding
import com.android.dutchman.domain.repository.setting.SettingRepository
import com.android.dutchman.presentation.viewmodel.setting.SettingViewModel
import com.android.dutchman.presentation.viewmodel.setting.SettingViewModelFactory
import com.android.dutchman.ui.activity.notice.LocationServiceTermsActivity
import com.android.dutchman.ui.activity.notice.PrivatePolicyActivity
import com.android.dutchman.ui.activity.notice.ServiceTermsActivity
import com.android.dutchman.ui.activity.setting.emailcertification.EmailCertificationActivity
import com.android.dutchman.ui.activity.setting.invitecode.InviteCodeActivity
import com.android.dutchman.ui.activity.setting.profilechange.ProfileChangeActivity
import com.android.dutchman.ui.activity.setting.pwchange.PwChangeActivity
import com.android.dutchman.util.DataBindingActivity
import org.jetbrains.anko.startActivity

class SettingActivity : DataBindingActivity<ActivitySettingBinding>(), SettingRepository {

    override val layoutId: Int
        get() = R.layout.activity_setting

    private val factory = SettingViewModelFactory(this)

    private val viewModel: SettingViewModel by lazy { ViewModelProviders.of(this, factory).get(SettingViewModel::class.java) }

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        viewModel.goBackLiveEvent.observe(this, Observer { finish() })
        viewModel.profileChangeLiveEvent.observe(this, Observer { startActivity<ProfileChangeActivity>() })
        viewModel.emailCertificationLiveEvent.observe(this, Observer { startActivity<EmailCertificationActivity>() })
        viewModel.pwChangeLiveEvent.observe(this, Observer { startActivity<PwChangeActivity>() })
        viewModel.recommendToFriendsLiveEvent.observe(this, Observer {  })
        viewModel.inviteCodeLiveEvent.observe(this, Observer { startActivity<InviteCodeActivity>() })
        viewModel.locationServiceLiveEvent.observe(this, Observer {  })
        viewModel.alertSetLiveEvent.observe(this, Observer {  })
        viewModel.marketingSetLiveEvent.observe(this, Observer {  })
        viewModel.seeNoticeLiveEvent.observe(this, Observer {  })
        viewModel.customerHelpLiveEvent.observe(this, Observer {  })
        viewModel.termsOfServiceLiveEvent.observe(this, Observer { startActivity<ServiceTermsActivity>() })
        viewModel.termsOfLocationLiveEvent.observe(this, Observer { startActivity<LocationServiceTermsActivity>() })
        viewModel.privatePolicyLiveEvent.observe(this, Observer { startActivity<PrivatePolicyActivity>() })
        viewModel.openSourceLiveEvent.observe(this, Observer {  })
        viewModel.logoutLiveEvent.observe(this, Observer {  })
        viewModel.signOutLiveEvent.observe(this, Observer {  })


    }

}