package com.android.dutchman.ui.activity.profileset

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Spannable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.ActivityProfileSetBinding
import com.android.dutchman.domain.repository.profileset.ProfileSetRepository
import com.android.dutchman.presentation.viewmodel.profileset.ProfileSetViewModel
import com.android.dutchman.presentation.viewmodel.profileset.ProfileSetViewModelFactory
import com.android.dutchman.ui.activity.alertset.AlertSetActivity
import com.android.dutchman.util.DataBindingActivity
import org.jetbrains.anko.startActivity
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.UnderlineSpan
import android.view.View
import com.android.dutchman.ui.activity.notice.LocationServiceTermsActivity
import com.android.dutchman.ui.activity.notice.PrivatePolicyActivity
import com.android.dutchman.ui.activity.notice.ServiceTermsActivity
import com.jaychang.st.OnTextClickListener
import com.jaychang.st.Range
import com.jaychang.st.SimpleText
import kotlinx.android.synthetic.main.activity_profile_set.*


class ProfileSetActivity : DataBindingActivity<ActivityProfileSetBinding>(),
    ProfileSetRepository {

    override val layoutId: Int
        get() = R.layout.activity_profile_set

    private val factory = ProfileSetViewModelFactory(this)

    private val viewModel: ProfileSetViewModel by lazy {
        ViewModelProviders.of(this, factory).get(
            ProfileSetViewModel::class.java
        )
    }


    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        doSpannableText("서비스 이용약관")
        doSpannableText("개인정보 처리방침")
        doSpannableText("위치기반 서비스 이용약관")
//        시작하기를 눌러, 서비스 이용약관 및 개인정보 처리방침, 위치기반 서비스 이용약관에 동의하고 14세 이상임을 인증합니다.


        viewModel.goAlertSetLiveEvent.observe(this, Observer { startActivity<AlertSetActivity>() })
        viewModel.goBackLiveEvent.observe(this, Observer { finish() })
        viewModel.setImageLiveEvent.observe(this, Observer { })
    }

    fun doSpannableText(string: String) {

    }


}