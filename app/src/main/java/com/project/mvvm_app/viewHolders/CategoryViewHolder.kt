package com.project.mvvm_app.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.mvvm_app.R
import com.project.mvvm_app.models.Category

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var categoryImageView: ImageView
    private lateinit var categoryNameTextView: TextView

    init {
        categoryImageView = itemView.findViewById(R.id.category_image)
        categoryNameTextView = itemView.findViewById(R.id.category_name)
    }

    fun bind(category: Category) {
        Glide.with(itemView.context).load(category.strCategoryThumb).into(categoryImageView)
        categoryNameTextView.text = category.strCategory
    }
}