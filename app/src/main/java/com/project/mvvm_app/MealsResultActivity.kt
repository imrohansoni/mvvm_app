package com.project.mvvm_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.mvvm_app.adapters.MealsResultAdapter
import com.project.mvvm_app.models.MealsResults
import com.project.mvvm_app.utils.Constants

class MealsResultActivity : AppCompatActivity() {
    private lateinit var mealsFilter: MealsResults
    private lateinit var mealsRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)
        mealsRecyclerView = findViewById(R.id.meals_recycler_view)

        mealsFilter = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.MEALS_RESULT, MealsResults::class.java)!!
        } else {
            intent.getParcelableExtra(Constants.MEALS_RESULT)!!
        }

        mealsRecyclerView.layoutManager = LinearLayoutManager(this)
        mealsRecyclerView.adapter = MealsResultAdapter(mealsFilter.mealResults)
    }
}