package com.android.dutchman.ui.fragment.mypage

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.PagerAdapter
import com.android.dutchman.R
import com.android.dutchman.databinding.FragmentMyPageBinding
import com.android.dutchman.domain.repository.mypage.MyPageRepository
import com.android.dutchman.presentation.viewmodel.mypage.MyPageViewModel
import com.android.dutchman.presentation.viewmodel.mypage.MyPageViewModelFactory
import com.android.dutchman.ui.activity.setting.SettingActivity
import com.android.dutchman.util.DataBindingFragment
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.startActivity

class MyPageFragment: DataBindingFragment<FragmentMyPageBinding>(), MyPageRepository {

    override val layoutId: Int
        get() = R.layout.fragment_my_page

    val compsite = CompositeDisposable()

    private val factory = MyPageViewModelFactory(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val viewModel = ViewModelProviders.of(this, factory).get(MyPageViewModel::class.java)

        viewModel.seeMyRoomLiveEvent.observe(this, Observer {  })
        viewModel.seeMyPostingLiveEvent.observe(this, Observer {  })
        viewModel.seeMyScrabLiveEvent.observe(this, Observer {  })
        viewModel.seeMyFriendLiveEvent.observe(this, Observer {  })
        viewModel.seeSettingLiveEvent.observe(this, Observer { startActivity<SettingActivity>() })

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        compsite.clear()
    }



}