package com.android.dutchman.presentation.viewmodel.signinemail

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.signinemail.SignInEmailRepository
import com.android.dutchman.ui.activity.signinemail.SignInEmailActivity
import com.android.dutchman.util.SingleLiveEvent
import com.google.firebase.auth.FirebaseAuth

class SignInEmailViewModel(val signInEmailRepository: SignInEmailRepository) : ViewModel() {

    val signInId = MutableLiveData<String>()
    val signInPw = MutableLiveData<String>()

    val signInEmailActivity = SignInEmailActivity()

    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    val goBackLiveEvent = SingleLiveEvent<Any>()
    val signupSuccessEmailLiveEvent = SingleLiveEvent<Any>()
    val signupFailedEmailLiveEvent = SingleLiveEvent<Any>()



    val btnColorSet = MediatorLiveData<Boolean>().apply {
        addSource(signInId) { this.value = !signInId.isValueBlank() && !signInPw.isValueBlank() }
        addSource(signInPw) { this.value = !signInId.isValueBlank() && !signInPw.isValueBlank() }
    }

    fun goBack() = goBackLiveEvent.call()
    fun doSignInEmail(){
        firebaseAuth.signInWithEmailAndPassword(signInId.value.toString(),signInPw.value.toString())
            .addOnCompleteListener(signInEmailActivity) {
                if (it.isSuccessful) {
                    signupSuccessEmailLiveEvent.call()
                } else {
                    signupFailedEmailLiveEvent.call()
                }
            }
            .addOnFailureListener {
                Log.d("DEBUGLOG", it.toString())
            }
    }

    fun MutableLiveData<String>.isValueBlank() = this.value.isNullOrBlank()

}