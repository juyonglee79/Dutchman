package com.android.dutchman.presentation.viewmodel.posting

import android.app.Application
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.posting.PostingRepository
import com.android.dutchman.util.LifecycleCallback
import com.android.dutchman.util.SingleLiveEvent

class PostingViewModel(val postingRepository: PostingRepository) : ViewModel(), LifecycleCallback {

    var selectedIndex = MutableLiveData<Int?>()

    val searchSomethingLiveEvent =  SingleLiveEvent<Any>()
    val contextInputLiveEvent = SingleLiveEvent<Any>()
    val groupBuyOptionLiveEvent = SingleLiveEvent<Any>()
    val imgSetOptionLiveEvent = SingleLiveEvent<Any>()
    val netflixOptionLiveEvent = SingleLiveEvent<Any>()
    val someoneProfileClickLiveEvent = SingleLiveEvent<Any>()
    val participatePostingLiveEvent = SingleLiveEvent<Any>()
    val sharePostingLiveEvent = SingleLiveEvent<Any>()

    fun searchSomething() = searchSomethingLiveEvent.call()
    fun contextInput() = contextInputLiveEvent.call()
    fun groupBuyOption() = groupBuyOptionLiveEvent.call()
    fun imgSetOption() = imgSetOptionLiveEvent.call()
    fun netflixOption() = netflixOptionLiveEvent.call()
    fun goSomeoneProfile() = someoneProfileClickLiveEvent.call()
    fun participatePosting() = participatePostingLiveEvent.call()
    fun sharePosting() = sharePostingLiveEvent.call()


    override fun apply(event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START -> {
            }
        }
    }

}