package com.android.dutchman.ui.activity.signinemail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.ActivitySignInEmailBinding
import com.android.dutchman.domain.repository.signinemail.SignInEmailRepository
import com.android.dutchman.presentation.viewmodel.signinemail.SignInEmailViewModel
import com.android.dutchman.presentation.viewmodel.signinemail.SignInEmailViewModelFactory
import com.android.dutchman.ui.activity.main.MainActivity
import com.android.dutchman.ui.activity.profileset.ProfileSetActivity
import com.android.dutchman.ui.activity.signin.SignInActivity
import com.android.dutchman.util.DataBindingActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SignInEmailActivity : DataBindingActivity<ActivitySignInEmailBinding>(),
    SignInEmailRepository {

    override val layoutId: Int
        get() = R.layout.activity_sign_in_email

    private val factory = SignInEmailViewModelFactory(this)

    private val viewModel: SignInEmailViewModel by lazy {
        ViewModelProviders.of(this, factory).get(
            SignInEmailViewModel::class.java
        )
    }

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        viewModel.signupSuccessEmailLiveEvent.observe(this, Observer {
            startActivity<MainActivity>()
            finish()
        })
        viewModel.signupFailedEmailLiveEvent.observe(this, Observer {
            toast("로그인 실패")
        })
        viewModel.goBackLiveEvent.observe(this, Observer { finish() })


    }

}