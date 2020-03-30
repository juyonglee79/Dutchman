package com.android.dutchman.presentation.viewmodel.signupemail

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.signupemail.SignUpEmailRepository
import com.android.dutchman.util.SingleLiveEvent


class SignUpEmailViewModel(val signUpEmailRepository: SignUpEmailRepository) : ViewModel() {

    val signupId = MutableLiveData<String>()
    val signupPw = MutableLiveData<String>()
    val signupPwCheck = MutableLiveData<String>()

    val goBackLiveEvent = SingleLiveEvent<Any>()
    val doSignupEmailLiveEvent = SingleLiveEvent<Any>()

    val btnColorSet = MediatorLiveData<Boolean>().apply {
        addSource(signupId) { this.value = !signupId.isValueBlank() && !signupPw.isValueBlank() && !signupPwCheck.isValueBlank() }
        addSource(signupPw) { this.value = !signupId.isValueBlank() && !signupPw.isValueBlank() && !signupPwCheck.isValueBlank() }
        addSource(signupPwCheck) { this.value = !signupId.isValueBlank() && !signupPw.isValueBlank() && !signupPwCheck.isValueBlank() }
    }

    fun goBack() = goBackLiveEvent.call()
    fun doSignUpEmail() = doSignupEmailLiveEvent.call()

    fun MutableLiveData<String>.isValueBlank() = this.value.isNullOrBlank()

}