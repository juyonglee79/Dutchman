package com.android.dutchman.presentation.viewmodel.chat

import androidx.lifecycle.ViewModel
import com.android.dutchman.domain.repository.chat.ChatRepository

class ChatViewModel(val chatRepository: ChatRepository) : ViewModel() {
}