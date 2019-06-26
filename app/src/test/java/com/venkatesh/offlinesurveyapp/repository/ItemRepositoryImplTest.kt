package com.venkatesh.offlinesurveyapp.repository


import com.venkatesh.offlinesurveyapp.common.LiveDataResource
import com.venkatesh.offlinesurveyapp.items.repository.ItemRepositoryImpl
import org.junit.Assert
import org.junit.Test

class ItemRepositoryImplTest {
    var mockModelManager = MockModelManager()
    var sut = ItemRepositoryImpl(mockModelManager)

    @Test
    fun testCheckResponseNullStatusWhenSutGetItemsMethodIsCalled(){
        sut.getItems("sampleUrl1", null){
            it?.let {
                println("live status : " + it.status)
                Assert.assertEquals(it.status, LiveDataResource.Status.ERROR)
            }
        }
    }
}