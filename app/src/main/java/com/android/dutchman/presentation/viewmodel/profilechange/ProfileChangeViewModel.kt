package com.android.dutchman.presentation.viewmodel.profilechange

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.profilechange.ProfileChangeRepository
import com.android.dutchman.util.SingleLiveEvent

class ProfileChangeViewModel (val profileChangeRepository: ProfileChangeRepository) : ViewModel() {

    val profileName = MutableLiveData<String>()

    val goBackLiveEvent = SingleLiveEvent<Any>()
    val setImageLiveEvent = SingleLiveEvent<Any>()
    val changeProfileSetLiveEvent = SingleLiveEvent<Any>()

    val btnColorSet = MediatorLiveData<Boolean>().apply {
        addSource(profileName) { this.value = !profileName.isValueBlank() }
    }

    fun goBack() = goBackLiveEvent.call()
    fun setImage() = setImageLiveEvent.call()
    fun changeProfile() = changeProfileSetLiveEvent.call()


    fun MutableLiveData<String>.isValueBlank() = this.value.isNullOrBlank()

}