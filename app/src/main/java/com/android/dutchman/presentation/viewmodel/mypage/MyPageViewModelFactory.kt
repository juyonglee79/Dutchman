package com.android.dutchman.presentation.viewmodel.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.mypage.MyPageRepository

class MyPageViewModelFactory(val myPageRepository: MyPageRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            modelClass.getConstructor(MyPageRepository::class.java).newInstance(myPageRepository)
}