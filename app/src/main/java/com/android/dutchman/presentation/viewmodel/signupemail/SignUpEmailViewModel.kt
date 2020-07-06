package com.android.dutchman.presentation.viewmodel.signupemail

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.signupemail.SignUpEmailRepository
import com.android.dutchman.util.SingleLiveEvent
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast
import android.R
import android.content.Context
import android.util.Log
import com.android.dutchman.ui.activity.main.MainActivity
import com.android.dutchman.ui.activity.signupemail.SignUpEmailActivity
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.OnCompleteListener
import org.jetbrains.anko.toast
import org.jetbrains.anko.wrapContent


class SignUpEmailViewModel(val signUpEmailRepository: SignUpEmailRepository) : ViewModel() {

    val signupId = MutableLiveData<String>()
    val signupPw = MutableLiveData<String>()
    val signupPwCheck = MutableLiveData<String>()
    val signUpEmailActivity = SignUpEmailActivity()

    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    val goBackLiveEvent = SingleLiveEvent<Any>()
    val signupEmailFailedLiveEvent = SingleLiveEvent<Any>()
    val signUpEmailSuccessLiveEvent = SingleLiveEvent<Any>()

    val btnColorSet = MediatorLiveData<Boolean>().apply {
        addSource(signupId) {
            this.value =
                !signupId.isValueBlank() && !signupPw.isValueBlank() && !signupPwCheck.isValueBlank()
        }
        addSource(signupPw) {
            this.value =
                !signupId.isValueBlank() && !signupPw.isValueBlank() && !signupPwCheck.isValueBlank()
        }
        addSource(signupPwCheck) {
            this.value =
                !signupId.isValueBlank() && !signupPw.isValueBlank() && !signupPwCheck.isValueBlank()
        }
    }


    fun goBack() = goBackLiveEvent.call()
    fun doSignUpEmail() {
        firebaseAuth.createUserWithEmailAndPassword(signupId.value.toString(),signupPw.value.toString())
            .addOnCompleteListener(signUpEmailActivity) {
                if (it.isSuccessful) {
                    signUpEmailSuccessLiveEvent.call()
                } else {
                    signupEmailFailedLiveEvent.call()
                }
            }
            .addOnFailureListener {
                Log.d("DEBUGLOG", it.toString())
            }
    }

    fun MutableLiveData<String>.isValueBlank() = this.value.isNullOrBlank()

}