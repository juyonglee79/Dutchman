package com.android.dutchman.presentation.viewmodel.demandconfirm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dutchman.domain.repository.demandconfirm.DemandConfirmRepository

class DemandConfirmViewModelFactory(val demandConfirmRepository: DemandConfirmRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(DemandConfirmRepository::class.java).newInstance(demandConfirmRepository)

}