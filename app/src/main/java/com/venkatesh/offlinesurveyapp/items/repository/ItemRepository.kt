
package com.venkatesh.offlinesurveyapp.items.repository


import com.venkatesh.offlinesurveyapp.common.LiveDataResource
import com.venkatesh.offlinesurveyapp.items.repository.model.Item
import java.io.InputStream


interface ItemRepository {
    fun getItems(pageId: String,inputStream: InputStream?,  closure: (liveDataResource: LiveDataResource<Item>) -> Unit)
}