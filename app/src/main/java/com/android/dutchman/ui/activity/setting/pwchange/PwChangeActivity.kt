package com.android.dutchman.ui.activity.setting.pwchange

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.dutchman.R

class PwChangeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_pw_change)

    }

    fun goBack(v : View) = finish()
}