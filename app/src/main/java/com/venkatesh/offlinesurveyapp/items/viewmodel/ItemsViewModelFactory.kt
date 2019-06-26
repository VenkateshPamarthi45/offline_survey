package com.venkatesh.offlinesurveyapp.items.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.venkatesh.offlinesurveyapp.items.repository.ItemRepository

class ItemsViewModelFactory(private val itemRepository: ItemRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ItemViewModel(itemRepository) as T
    }
}