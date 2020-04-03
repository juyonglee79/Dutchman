package com.android.dutchman.presentation.viewmodel.myroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.myroom.MyRoomRepository

class MyRoomViewModelFactory(val myRoomRepository: MyRoomRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(MyRoomRepository::class.java).newInstance(myRoomRepository)
}