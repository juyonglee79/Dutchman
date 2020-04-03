package com.android.dutchman.presentation.viewmodel.notice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.notice.NoticeRepository

class NoticeViewModelFactory (val noticeRepository: NoticeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return NoticeViewModel(noticeRepository) as T
    }
}
