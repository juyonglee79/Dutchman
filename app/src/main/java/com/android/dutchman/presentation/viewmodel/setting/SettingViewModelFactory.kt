package com.android.dutchman.presentation.viewmodel.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.setting.SettingRepository
import com.android.dutchman.domain.repository.signupemail.SignUpEmailRepository
import com.android.dutchman.presentation.viewmodel.signupemail.SignUpEmailViewModel

@Suppress("UNCHECKED_CAST")
class SettingViewModelFactory(val settingRepository: SettingRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return SettingViewModel(settingRepository) as T
    }
}
