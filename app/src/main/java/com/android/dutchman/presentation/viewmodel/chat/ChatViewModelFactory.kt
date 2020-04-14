package com.android.dutchman.presentation.viewmodel.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.chat.ChatRepository

class ChatViewModelFactory(val chatRepository: ChatRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(ChatRepository::class.java).newInstance(chatRepository)
}