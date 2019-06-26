
package com.venkatesh.offlinesurveyapp.image_survey.repository


import com.venkatesh.offlinesurveyapp.common.LiveDataResource
import com.venkatesh.offlinesurveyapp.items.repository.model.Item
import java.io.InputStream


interface ImageSurveyRepository {
    fun getItems(pageId: String,inputStream: InputStream?,  closure: (liveDataResource: LiveDataResource<Item>) -> Unit)
}