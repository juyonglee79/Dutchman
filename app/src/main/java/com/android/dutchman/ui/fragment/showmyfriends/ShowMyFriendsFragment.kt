package com.android.dutchman.ui.fragment.showmyfriends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.PagerAdapter
import com.android.dutchman.R
import com.android.dutchman.databinding.FragmentShowMyFriendsBinding
import com.android.dutchman.domain.repository.showmyfriends.ShowMyFriendsRepository
import com.android.dutchman.presentation.model.MyFriendsModel
import com.android.dutchman.presentation.viewmodel.showmyfriends.ShowMyFriendsViewModel
import com.android.dutchman.presentation.viewmodel.showmyfriends.ShowMyFriendsViewModelFactory
import com.android.dutchman.ui.adapter.ShowMyFriendsAdapter
import com.android.dutchman.util.DataBindingFragment
import dsm.android.v3.presentation.di.scope.ActivityScope
import kotlinx.android.synthetic.main.fragment_show_my_friends.*
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.startActivity

@ActivityScope
class ShowMyFriendsFragment : DataBindingFragment<FragmentShowMyFriendsBinding>(), ShowMyFriendsRepository {

    override val layoutId: Int
        get() = R.layout.fragment_show_my_friends

    private val factory = ShowMyFriendsViewModelFactory(this)

    private val fm: FragmentManager? by lazy { fragmentManager }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!, factory).get(ShowMyFriendsViewModel::class.java)

        viewModel.inviteFriendsLiveEvent.observe(this, Observer {  })

        show_my_friendslist_rv.adapter = ShowMyFriendsAdapter(viewModel)

        binding.vm = viewModel

    }


}