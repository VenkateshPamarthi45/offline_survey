package com.venkatesh.offlinesurveyapp.image_survey.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.venkatesh.networklibrary.model.ModelManager
import com.venkatesh.offlinesurveyapp.R
import com.venkatesh.offlinesurveyapp.items.repository.model.Item

class ImageSurveyRecyclerViewAdapter(var modelManager: ModelManager?, var mItems: MutableList<Item.Data>) : RecyclerView.Adapter<ImageSurveyViewHolder>() {

    fun addAllItems(items: List<Item.Data>){
        mItems.addAll(items)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ImageSurveyViewHolder =
        ImageSurveyViewHolder(
            LayoutInflater.from(p0.context).inflate(
                R.layout.item_image_view,
                p0,
                false
            ), modelManager
        )

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = mItems.size

    override fun onBindViewHolder(p0: ImageSurveyViewHolder, p1: Int){
        p0.setItem(mItems[p1])
    }

}