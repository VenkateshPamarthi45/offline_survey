package com.venkatesh.offlinesurveyapp.items.repository.model


import com.google.gson.annotations.SerializedName

data class ResponseObject(
    @SerializedName("data")
    val `data`: List<Data>
) {
    data class Data(
        @SerializedName("display_text")
        val displayText: String,
        @SerializedName("percentage")
        val percentage: Int
    )
}