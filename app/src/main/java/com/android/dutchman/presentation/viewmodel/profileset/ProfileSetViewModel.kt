package com.android.dutchman.presentation.viewmodel.profileset

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.profileset.ProfileSetRepository
import com.android.dutchman.util.SingleLiveEvent

class ProfileSetViewModel (val profileSetRepository: ProfileSetRepository) : ViewModel() {

    val profileName = MutableLiveData<String>()

    val goBackLiveEvent = SingleLiveEvent<Any>()
    val setImageLiveEvent = SingleLiveEvent<Any>()
    val goAlertSetLiveEvent = SingleLiveEvent<Any>()

    val btnColorSet = MediatorLiveData<Boolean>().apply {
        addSource(profileName) { this.value = !profileName.isValueBlank() }
    }

    fun goBack() = goBackLiveEvent.call()
    fun setImage() = setImageLiveEvent.call()
    fun goAlertSet() = goAlertSetLiveEvent.call()


    fun MutableLiveData<String>.isValueBlank() = this.value.isNullOrBlank()

}