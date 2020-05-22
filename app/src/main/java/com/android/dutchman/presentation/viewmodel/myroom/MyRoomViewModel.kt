package com.android.dutchman.presentation.viewmodel.myroom

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.mypage.MyPageRepository
import com.android.dutchman.domain.repository.myroom.MyRoomRepository
import com.android.dutchman.presentation.model.MyRoomPagerModel
import com.android.dutchman.util.SingleLiveEvent
import java.text.SimpleDateFormat
import java.util.*

class MyRoomViewModel(val myRoomRepository: MyRoomRepository) : ViewModel() {

    val model = MutableLiveData<MyRoomPagerModel>()
    val addRoomSingleLiveEvent = SingleLiveEvent<Any>()


    fun addRoom() = addRoomSingleLiveEvent.call()


}