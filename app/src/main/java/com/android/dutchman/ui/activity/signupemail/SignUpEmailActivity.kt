package com.android.dutchman.ui.activity.signupemail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.ActivitySignUpEmailBinding
import com.android.dutchman.domain.repository.signupemail.SignUpEmailRepository
import com.android.dutchman.presentation.viewmodel.signupemail.SignUpEmailViewModel
import com.android.dutchman.presentation.viewmodel.signupemail.SignUpEmailViewModelFactory
import com.android.dutchman.ui.activity.main.MainActivity
import com.android.dutchman.ui.activity.profileset.ProfileSetActivity
import com.android.dutchman.util.DataBindingActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SignUpEmailActivity : DataBindingActivity<ActivitySignUpEmailBinding>(),
    SignUpEmailRepository {

    override val layoutId: Int
        get() = R.layout.activity_sign_up_email

    private val factory = SignUpEmailViewModelFactory(this)

    private val viewModel: SignUpEmailViewModel by lazy {
        ViewModelProviders.of(this, factory).get(
            SignUpEmailViewModel::class.java
        )
    }

    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()


    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        viewModel.signUpEmailSuccessLiveEvent.observe(this, Observer {
            startActivity<ProfileSetActivity>()
            finish()
        })
        viewModel.signupEmailFailedLiveEvent.observe(this, Observer {
           toast("회원가입에 실패했습니다.")
        })
        viewModel.goBackLiveEvent.observe(this, Observer { finish() })

    }

}