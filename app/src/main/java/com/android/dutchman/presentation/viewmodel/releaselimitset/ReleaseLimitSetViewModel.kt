package com.android.dutchman.presentation.viewmodel.releaselimitset

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.releaselimitset.ReleaseLimitSetRepository
import com.android.dutchman.util.SingleLiveEvent

class ReleaseLimitSetViewModel(val releaseLimitSetRepository: ReleaseLimitSetRepository) :
    ViewModel() {
    val cancelLiveEvent = SingleLiveEvent<Any>()
    val setReleaseLimitLiveEvent = SingleLiveEvent<Any>()

    var selectedLimit = MutableLiveData<String>()
    var selectedIndex = MutableLiveData<Int>()

    fun doCancel() = cancelLiveEvent.call()
    fun setReleaseLimit() = setReleaseLimitLiveEvent.call()
    fun setWhichIsChecked(index: Int) {
        when (index) {
            1 -> { selectedLimit.value = "전체 공개"
                    selectedIndex.value = 1 }
            2 -> { selectedLimit.value = "친구만"
                    selectedIndex.value = 2 }
            3 -> { selectedLimit.value = "나만 보기"
                    selectedIndex.value = 3 }
        }
    }
}