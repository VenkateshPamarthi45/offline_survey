package com.venkatesh.offlinesurveyapp.items.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.venkatesh.offlinesurveyapp.common.LiveDataResource
import com.venkatesh.offlinesurveyapp.items.repository.ItemRepository
import com.venkatesh.offlinesurveyapp.items.repository.model.Item
import java.io.InputStream

/**
 *
 * @property itemRepository ItemRepository
 * @property items MutableLiveData<MutableList<Item>>?
 * @constructor
 */
class ItemViewModel(private val itemRepository: ItemRepository):ViewModel() {

    private var items : MutableLiveData<LiveDataResource<Item>>? = null
    var savedItems : MutableList<Item.Data>? = null

    /**
     *
     * @param pageId String
     * @return MutableLiveData<MutableList<Item>>?
     */
    fun getItems(pageId: String, inputStream: InputStream?): MutableLiveData<LiveDataResource<Item>>? {
        items = MutableLiveData()

        itemRepository.getItems(pageId, inputStream){ liveDataResource ->
            items?.value = liveDataResource
        }
        return items
    }
}