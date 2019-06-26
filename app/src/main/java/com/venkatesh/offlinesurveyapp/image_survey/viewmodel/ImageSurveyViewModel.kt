package com.venkatesh.offlinesurveyapp.image_survey.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.venkatesh.offlinesurveyapp.common.LiveDataResource
import com.venkatesh.offlinesurveyapp.image_survey.repository.ImageSurveyRepository
import com.venkatesh.offlinesurveyapp.items.repository.model.Item
import java.io.InputStream

/**
 *
 * @property itemRepository ItemRepository
 * @property items MutableLiveData<MutableList<Item>>?
 * @constructor
 */
class ImageSurveyViewModel(private val imageSurveyRepository: ImageSurveyRepository):ViewModel() {

    private var items : MutableLiveData<LiveDataResource<Item>>? = null
    var savedItems : MutableList<Item.Data>? = null

    /**
     *
     * @param pageId String
     * @return MutableLiveData<MutableList<Item>>?
     */
    fun getItems(pageId: String, inputStream: InputStream?): MutableLiveData<LiveDataResource<Item>>? {
        items = MutableLiveData()

        imageSurveyRepository.getItems(pageId, inputStream){ liveDataResource ->
            items?.value = liveDataResource
        }
        return items
    }
}