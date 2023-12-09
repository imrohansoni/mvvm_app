package com.project.mvvm_app.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.mvvm_app.R
import com.project.mvvm_app.models.MealResult

class MealsResultViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var mealImageView: ImageView = itemView.findViewById(R.id.meal_image)
    private var mealNameTextView: TextView = itemView.findViewById(R.id.meal_name)

    fun bind(mealResult: MealResult) {
        mealNameTextView.text = mealResult.strMeal
        Glide.with(itemView.context).load(mealResult.strMealThumb).into(mealImageView)
    }
}