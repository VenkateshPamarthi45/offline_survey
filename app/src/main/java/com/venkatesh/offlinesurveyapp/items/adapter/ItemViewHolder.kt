package com.venkatesh.offlinesurveyapp.items.adapter

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.venkatesh.networklibrary.model.ModelManager
import com.venkatesh.offlinesurveyapp.R
import com.venkatesh.offlinesurveyapp.items.repository.model.Item
import com.venkatesh.offlinesurveyapp.items.view.ItemListingFragment

/**
 * Class extends [RecyclerView.ViewHolder]
 * @param itemView is the instance of view
 * @param listener is [ItemListingFragment.OnWatchlistItemListener] listener
 */
class ItemViewHolder(itemView: View, listener: ItemListingFragment.OnWatchlistItemListener?, var modelManager: ModelManager?): RecyclerView.ViewHolder(itemView) {

    private var item: Item.Data? = null
    private var progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
    private var titleTextView: AppCompatTextView = itemView.findViewById(R.id.title)
    private var percentageTextView: AppCompatTextView = itemView.findViewById(R.id.percentage_label)
    init {
        progressBar.setOnClickListener {
            listener?.onListClickInteraction(
                item!!, ""
            )
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
    }

}