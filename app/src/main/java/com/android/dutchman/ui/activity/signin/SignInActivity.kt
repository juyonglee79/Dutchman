package com.android.dutchman.ui.activity.signin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.android.dutchman.R
import com.android.dutchman.ui.activity.appintro.AppIntroActivity
import com.android.dutchman.ui.activity.main.MainActivity
import com.android.dutchman.ui.activity.signinemail.SignInEmailActivity
import com.android.dutchman.ui.activity.signup.SignUpActivity
import com.android.dutchman.ui.activity.signupemail.SignUpEmailActivity
import com.android.dutchman.ui.dialogfragment.invitefriend.InviteFriendDialogFragment
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

    }

    fun goSignUp(v : View) = startActivity(intentFor<SignUpActivity>().addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))

    fun goAppIntro(v : View){

    }
    fun goSignUpEmail(v : View) {
        startActivity<SignUpEmailActivity>()
        overridePendingTransition(R.anim.slide_left, R.anim.slide_right)
    }
    fun goSignInEmail(v : View){
        startActivity<SignInEmailActivity>()
        overridePendingTransition(R.anim.slide_left, R.anim.slide_right)
    }
    fun doInquire(v : View){

    }

}