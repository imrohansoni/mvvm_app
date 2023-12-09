package com.project.mvvm_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.mvvm_app.R
import com.project.mvvm_app.models.MealResult
import com.project.mvvm_app.viewHolders.MealsResultViewHolder

class MealsResultAdapter(private val mealResults: List<MealResult>) : RecyclerView.Adapter<MealsResultViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsResultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.meal_search_result, parent, false)
        return MealsResultViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mealResults.size
    }

    override fun onBindViewHolder(holder: MealsResultViewHolder, position: Int) {
        holder.bind(mealResults[position])
    }
}