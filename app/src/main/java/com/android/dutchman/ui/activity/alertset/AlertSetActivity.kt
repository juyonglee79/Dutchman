package com.android.dutchman.ui.activity.alertset

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.android.dutchman.R
import com.android.dutchman.ui.activity.main.MainActivity
import org.jetbrains.anko.startActivity
import java.util.jar.Manifest

class AlertSetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_set)
    }

    fun setAlert(v:View){

    }

    fun setAlertCancel(v:View) {
        startActivity<MainActivity>()
        finish()
    }



}