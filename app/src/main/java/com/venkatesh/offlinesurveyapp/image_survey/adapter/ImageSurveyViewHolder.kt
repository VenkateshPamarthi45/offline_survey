package com.venkatesh.offlinesurveyapp.image_survey.adapter

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.venkatesh.networklibrary.createBitMapFromResponseBody
import com.venkatesh.networklibrary.model.ModelManager
import com.venkatesh.offlinesurveyapp.R
import com.venkatesh.offlinesurveyapp.items.repository.model.Item
import com.venkatesh.offlinesurveyapp.items.view.ItemListingFragment

/**
 * Class extends [RecyclerView.ViewHolder]
 * @param itemView is the instance of view
 * @param listener is [ItemListingFragment.OnWatchlistItemListener] listener
 */
class ImageSurveyViewHolder(itemView: View, var modelManager: ModelManager?): RecyclerView.ViewHolder(itemView) {

    private var item: Item.Data? = null
    private var progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
    private var titleTextView: AppCompatTextView = itemView.findViewById(R.id.title)
    private var imageView: AppCompatImageView = itemView.findViewById(R.id.imageView)
    private var percentageTextView: AppCompatTextView = itemView.findViewById(R.id.percentage_label)

    init {
        progressBar.setOnClickListener {
        }
    }
    /**
     * In this method, the views are updated with data
     * @param item is the instance of [Item]
     */
    fun setItem(item: Item.Data ) {
        this.item = item
        titleTextView.text = item.displayText
        progressBar.progress = item.percentage
        percentageTextView.text = item.percentage.toString() + "%"
        item.imageUrl?.let {
            modelManager?.getRequestForImage(it){
                response, inputStream, call ->
                imageView.createBitMapFromResponseBody(inputStream)
            }
        }

    }

}