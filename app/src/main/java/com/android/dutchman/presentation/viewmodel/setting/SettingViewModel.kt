package com.android.dutchman.presentation.viewmodel.setting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.setting.SettingRepository
import com.android.dutchman.util.SingleLiveEvent

class SettingViewModel(val settingRepository: SettingRepository) : ViewModel() {

    val goBackLiveEvent = SingleLiveEvent<Any>()
    val profileChangeLiveEvent = SingleLiveEvent<Any>()
    val emailCertificationLiveEvent = SingleLiveEvent<Any>()
    val pwChangeLiveEvent = SingleLiveEvent<Any>()
    val recommendToFriendsLiveEvent = SingleLiveEvent<Any>()
    val inviteCodeLiveEvent = SingleLiveEvent<Any>()
    val locationServiceLiveEvent = SingleLiveEvent<Any>()
    val alertSetLiveEvent = SingleLiveEvent<Any>()
    val marketingSetLiveEvent = SingleLiveEvent<Any>()
    val seeNoticeLiveEvent = SingleLiveEvent<Any>()
    val customerHelpLiveEvent = SingleLiveEvent<Any>()
    val termsOfServiceLiveEvent = SingleLiveEvent<Any>()
    val termsOfLocationLiveEvent = SingleLiveEvent<Any>()
    val privatePolicyLiveEvent = SingleLiveEvent<Any>()
    val openSourceLiveEvent = SingleLiveEvent<Any>()
    val logoutLiveEvent = SingleLiveEvent<Any>()
    val signOutLiveEvent = SingleLiveEvent<Any>()

    fun goBack() = goBackLiveEvent.call()
    fun profileChange() = profileChangeLiveEvent.call()
    fun emailCertification() = emailCertificationLiveEvent.call()
    fun pwChange() = pwChangeLiveEvent.call()
    fun recommendToFriends() = recommendToFriendsLiveEvent.call()
    fun inviteCode() = inviteCodeLiveEvent.call()
    fun locationService() = locationServiceLiveEvent.call()
    fun alertSet() = alertSetLiveEvent.call()
    fun marketingSet() = marketingSetLiveEvent.call()
    fun seeNotice() = seeNoticeLiveEvent.call()
    fun customerHelp() = customerHelpLiveEvent.call()
    fun termsOfService() = termsOfServiceLiveEvent.call()
    fun termsOfLocation() = termsOfLocationLiveEvent.call()
    fun privatePolicy() = privatePolicyLiveEvent.call()
    fun openSource() = openSourceLiveEvent.call()
    fun logout() = logoutLiveEvent.call()
    fun signOut() = signOutLiveEvent.call()

    fun MutableLiveData<String>.isValueBlank() = this.value.isNullOrBlank()

}