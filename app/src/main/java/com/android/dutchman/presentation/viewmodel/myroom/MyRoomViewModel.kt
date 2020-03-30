package com.android.dutchman.presentation.viewmodel.myroom

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.mypage.MyPageRepository
import com.android.dutchman.presentation.model.MyRoomPagerModel
import java.text.SimpleDateFormat
import java.util.*

class MyRoomViewModel(val myPageRepository: MyPageRepository) : ViewModel() {

    val pageStatusLiveData = MutableLiveData<Int>()
    val model = MutableLiveData<MyRoomPagerModel>()


}