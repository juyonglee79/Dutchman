package com.android.dutchman.presentation.viewmodel.addpost

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.addpost.AddPostRepository
import com.android.dutchman.util.SingleLiveEvent

class AddPostViewModel(val addPostRepository: AddPostRepository) : ViewModel() {

    val postContext = MutableLiveData<String>()
    val postLimit = MutableLiveData<String>()
    val postPeopleCount = MutableLiveData<String>()
    val noLimitCheck = MutableLiveData<Boolean>()

    val cancelLiveEvent = SingleLiveEvent<Any>()
    val doPostLiveEvent = SingleLiveEvent<Any>()
    val setLimitLiveEvent = SingleLiveEvent<Any>()
    val setImageLiveEvent = SingleLiveEvent<Any>()
    val setNetflixFormLiveEvent = SingleLiveEvent<Any>()
    val setGroupBuyFormLiveEvent = SingleLiveEvent<Any>()
    val inviteFriendLiveEvent = SingleLiveEvent<Any>()

    val btnColorSet = MediatorLiveData<Boolean>().apply {
        addSource(postContext) { this.value = !postContext.isValueBlank() && !postPeopleCount.isValueBlank() }
        addSource(postPeopleCount) { this.value = !postContext.isValueBlank() && !postPeopleCount.isValueBlank() }
    }


    fun doCancel() = cancelLiveEvent.call()
    fun doPost() = doPostLiveEvent.call()
    fun setLimit() = setLimitLiveEvent.call()
    fun setImage() = setImageLiveEvent.call()
    fun setNetflixForm() = setNetflixFormLiveEvent.call()
    fun setGroupBuyForm() = setGroupBuyFormLiveEvent.call()
    fun inviteFriend() = inviteFriendLiveEvent.call()

    fun MutableLiveData<String>.isValueBlank() = this.value.isNullOrBlank()


}