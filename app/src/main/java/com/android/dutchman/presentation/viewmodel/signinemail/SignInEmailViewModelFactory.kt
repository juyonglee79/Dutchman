package com.android.dutchman.presentation.viewmodel.signinemail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.signinemail.SignInEmailRepository

class SignInEmailViewModelFactory(val signInEmailRepository: SignInEmailRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return SignInEmailViewModel(signInEmailRepository) as T
    }
}
