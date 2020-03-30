package com.android.dutchman.presentation.viewmodel.signinemail

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.signinemail.SignInEmailRepository
import com.android.dutchman.util.SingleLiveEvent

class SignInEmailViewModel(val signInEmailRepository: SignInEmailRepository) : ViewModel() {

    val signupId = MutableLiveData<String>()
    val signupPw = MutableLiveData<String>()

    val goBackLiveEvent = SingleLiveEvent<Any>()
    val doSignupEmailLiveEvent = SingleLiveEvent<Any>()

    val btnColorSet = MediatorLiveData<Boolean>().apply {
        addSource(signupId) { this.value = !signupId.isValueBlank() && !signupPw.isValueBlank() }
        addSource(signupPw) { this.value = !signupId.isValueBlank() && !signupPw.isValueBlank() }
    }

    fun goBack() = goBackLiveEvent.call()
    fun doSignInEmail() = doSignupEmailLiveEvent.call()

    fun MutableLiveData<String>.isValueBlank() = this.value.isNullOrBlank()

}