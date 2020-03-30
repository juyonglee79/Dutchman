package com.android.dutchman.ui.activity.setting.emailcertification

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.dutchman.R

class EmailCertificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_email_certification)


    }

    fun goBack(v : View) = finish()
}