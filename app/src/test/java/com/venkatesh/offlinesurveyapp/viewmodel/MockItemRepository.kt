package com.venkatesh.offlinesurveyapp.viewmodel

import com.venkatesh.offlinesurveyapp.common.LiveDataResource
import com.venkatesh.offlinesurveyapp.items.repository.ItemRepository
import com.venkatesh.offlinesurveyapp.items.repository.model.Item
import java.io.InputStream


class MockItemRepository: ItemRepository {

    var isGetItemsMethodIsCalled = false
    override fun getItems(pageId: String, inputStream: InputStream?, closure: (liveDataResource: LiveDataResource<Item>) -> Unit) {
        isGetItemsMethodIsCalled = true
        if(pageId == "sampleUrl1"){
            closure(LiveDataResource.error(404, "Invalid user", null, null))
        }
    }

}
