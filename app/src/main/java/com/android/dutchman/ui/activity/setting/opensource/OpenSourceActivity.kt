package com.android.dutchman.ui.activity.setting.opensource

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.dutchman.R

class OpenSourceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_open_source)

    }

    fun goBack(v : View) = finish()
}