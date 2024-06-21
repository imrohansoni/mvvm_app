package com.project.mvvm_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.mvvm_app.databinding.MealCategoryBinding
import com.project.mvvm_app.models.Category


class CategoriesAdapter(
    private val categories: List<Category>,
    private val clickListener: (categoryName: String) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    private lateinit var binding: MealCategoryBinding

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(category: Category, clickListener: (categoryId: String) -> Unit) {
            Glide.with(itemView.context).load(category.thumb).into(binding.categoryImage)
            binding.categoryName.text = category.category
            binding.categoryConstraintLayout.setOnClickListener {
                clickListener(category.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = MealCategoryBinding.inflate(inflater, parent, false)
        return CategoryViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position], clickListener)
    }
}