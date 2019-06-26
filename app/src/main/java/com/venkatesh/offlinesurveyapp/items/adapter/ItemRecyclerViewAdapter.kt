package com.venkatesh.offlinesurveyapp.items.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.venkatesh.networklibrary.model.ModelManager
import com.venkatesh.offlinesurveyapp.R
import com.venkatesh.offlinesurveyapp.items.repository.model.Item
import com.venkatesh.offlinesurveyapp.items.view.ItemListingFragment

class ItemRecyclerViewAdapter(var modelManager: ModelManager?, var mItems: MutableList<Item.Data>, var listener: ItemListingFragment.OnWatchlistItemListener?) : RecyclerView.Adapter<ItemViewHolder>() {

    fun addAllItems(items: List<Item.Data>){
        mItems.addAll(items)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater.from(p0.context).inflate(
                R.layout.item_text_view,
                p0,
                false
            ), listener, modelManager
        )

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = mItems.size

    override fun onBindViewHolder(p0: ItemViewHolder, p1: Int){
        p0.setItem(mItems[p1])
    }

}