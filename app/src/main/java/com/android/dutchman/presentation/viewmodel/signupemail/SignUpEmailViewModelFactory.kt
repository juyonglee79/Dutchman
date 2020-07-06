package com.android.dutchman.presentation.viewmodel.signupemail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.signupemail.SignUpEmailRepository

@Suppress("UNCHECKED_CAST")
class SignUpEmailViewModelFactory(val signUpEmailRepository: SignUpEmailRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignUpEmailViewModel(signUpEmailRepository) as T
    }
}
