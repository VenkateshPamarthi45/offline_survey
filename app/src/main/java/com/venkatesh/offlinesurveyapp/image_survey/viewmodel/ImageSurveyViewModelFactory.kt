package com.venkatesh.offlinesurveyapp.image_survey.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.venkatesh.offlinesurveyapp.image_survey.repository.ImageSurveyRepository

class ImageSurveyViewModelFactory(private val imageSurveyRepository: ImageSurveyRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageSurveyViewModel(imageSurveyRepository) as T
    }
}