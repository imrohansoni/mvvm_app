package com.project.mvvm_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.mvvm_app.R
import com.project.mvvm_app.models.Categories
import com.project.mvvm_app.viewHolders.CategoryViewHolder

class CategoriesAdapter(
    private val categories: Categories, private val clickListener: (categoryName: String) -> Unit
) : RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.meal_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories.categories[position], clickListener)
    }
}