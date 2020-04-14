package com.android.dutchman.ui.fragment.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.FragmentChatBinding
import com.android.dutchman.domain.repository.chat.ChatRepository
import com.android.dutchman.presentation.viewmodel.chat.ChatViewModel
import com.android.dutchman.presentation.viewmodel.chat.ChatViewModelFactory
import com.android.dutchman.util.DataBindingFragment
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.support.v4.startActivity

class ChatFragment : DataBindingFragment<FragmentChatBinding>(), ChatRepository {

    override val layoutId: Int
        get() = R.layout.fragment_chat

    val compsite = CompositeDisposable()

    private val factory = ChatViewModelFactory(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!, factory).get(ChatViewModel::class.java)
        binding.vm = viewModel


        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        compsite.clear()
    }

}