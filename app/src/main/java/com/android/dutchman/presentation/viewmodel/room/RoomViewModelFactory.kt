package com.android.dutchman.presentation.viewmodel.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.room.RoomRepository

class RoomViewModelFactory(val roomRepository: RoomRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return RoomViewModel(roomRepository) as T
    }
}
