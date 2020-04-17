package com.android.dutchman.ui.activity.room

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.R
import com.android.dutchman.databinding.ActivityRoomBinding
import com.android.dutchman.domain.repository.room.RoomRepository
import com.android.dutchman.presentation.viewmodel.room.RoomViewModel
import com.android.dutchman.presentation.viewmodel.room.RoomViewModelFactory
import com.android.dutchman.ui.fragment.chat.ChatFragment
import com.android.dutchman.ui.fragment.mypage.MyPageFragment
import com.android.dutchman.ui.fragment.payment.PaymentFragment
import com.android.dutchman.ui.fragment.posting.PostingFragment
import com.android.dutchman.util.DataBindingActivity

class RoomActivity : DataBindingActivity<ActivityRoomBinding>(), RoomRepository{

    override val layoutId: Int
        get() = R.layout.activity_room

    private val factory = RoomViewModelFactory(this)

    private val viewModel: RoomViewModel by lazy {
        ViewModelProviders.of(this, factory).get(RoomViewModel::class.java)
    }

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        baseSet(viewModel)

        viewModel.showSettingLiveEvent.observe(this, Observer { })
        viewModel.showChatLiveEvent.observe(this, Observer {
            supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                .replace(R.id.room_main_container, ChatFragment()).commit() })
        viewModel.showPaymentLiveEvent.observe(this, Observer {
            supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
                .replace(R.id.room_main_container, PaymentFragment()).commit() })
    }

    private fun baseSet(viewModel: RoomViewModel){
        supportFragmentManager.beginTransaction().run {
            replace(R.id.room_main_container, ChatFragment())
            commit()
        }
        viewModel.chatBtnColorSet.value = false
        viewModel.paymentBtnColorSet.value = true
    }

}