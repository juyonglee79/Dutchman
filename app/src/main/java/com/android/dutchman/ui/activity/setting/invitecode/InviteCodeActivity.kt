package com.android.dutchman.ui.activity.setting.invitecode

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.dutchman.R

class InviteCodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_invite_code)

    }

    fun goBack(v : View) = finish()
}