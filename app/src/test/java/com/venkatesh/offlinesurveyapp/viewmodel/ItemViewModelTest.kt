package com.venkatesh.offlinesurveyapp.viewmodel


import com.venkatesh.offlinesurveyapp.items.viewmodel.ItemViewModel
import org.junit.Assert
import org.junit.Test

class ItemViewModelTest {
    private val mockItemRepository = MockItemRepository()
    private var sut = ItemViewModel(mockItemRepository)

    @Test
    fun testCheckItemRepositoryGetMethodIsCalledWhenGetItemsInViewModelIsCalled(){
        val items = sut.getItems("sampleUrl", null)
        Assert.assertTrue(mockItemRepository.isGetItemsMethodIsCalled)
    }
}