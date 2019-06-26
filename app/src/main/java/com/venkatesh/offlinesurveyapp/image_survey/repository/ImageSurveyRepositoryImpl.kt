
package com.venkatesh.offlinesurveyapp.image_survey.repository

import com.google.gson.Gson
import com.venkatesh.networklibrary.model.ModelManager
import com.venkatesh.offlinesurveyapp.common.LiveDataResource
import com.venkatesh.offlinesurveyapp.items.repository.model.Item
import java.io.IOException
import java.io.InputStream

/**
 *
 * @property modelManager ModelManager
 * @constructor
 */
class ImageSurveyRepositoryImpl(var modelManager: ModelManager): ImageSurveyRepository {

    /**
     *
     * @param pageId String
     * @param closure Function4<[@kotlin.ParameterName] Response<ResponseBody>?, [@kotlin.ParameterName] List<Item>?, [@kotlin.ParameterName] String?, [@kotlin.ParameterName] Deferred<Response<ResponseBody>>?, Unit>
     */
    override fun getItems(pageId: String, inputStream: InputStream?, closure: (liveDataSource: LiveDataResource<Item>) -> Unit) {
        var json: String? = null
        try {
            inputStream?.let {
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer)
                val item  = Gson().fromJson(json, Item::class.java)
                val statusCode = 0
                closure(LiveDataResource.success(statusCode,item, null))
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        // Normal API working in these way
/*        modelManager.getRequest(pageId){ response, responseBodyString,  call ->
            if(responseBodyString == null && response == null && call != null){
                println(" call is not null")
                closure(LiveDataResource.loading(null, call))
            } else if(responseBodyString != null){
                println("responseBodyString is not null " + responseBodyString)
                var item  = Gson().fromJson(responseBodyString, Item::class.java)
                val statusCode = response?.code() ?: 0
                closure(LiveDataResource.success(statusCode,item, call))
            }else if(response != null){
                println("responseBodyString is null")
                closure(LiveDataResource.error(response.code(), response.message(), null, call))
            }else{
                println(" response is null")
                closure(LiveDataResource.error(500, "Internal Error", null, call))
            }
        }*/
    }
}