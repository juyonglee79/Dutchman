package com.android.dutchman.ui.activity.signup

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.dutchman.R
import com.android.dutchman.ui.activity.appintro.AppIntroActivity
import com.android.dutchman.ui.activity.signinemail.SignInEmailActivity
import com.android.dutchman.ui.activity.signupemail.SignUpEmailActivity
import org.jetbrains.anko.startActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

    }

    fun goSignUpEmail(v : View) = startActivity<SignUpEmailActivity>()
    fun goSignInEmail(v : View) = startActivity<SignInEmailActivity>()
    fun goAppIntro(v: View) = startActivity<AppIntroActivity>()
    fun doInquire(v : View){

    }

}