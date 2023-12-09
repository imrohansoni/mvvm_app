package com.project.mvvm_app.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.mvvm_app.R
import com.project.mvvm_app.MealsResultActivity
import com.project.mvvm_app.adapters.CategoriesAdapter
import com.project.mvvm_app.api.ApiService
import com.project.mvvm_app.api.RetrofitInstance
import com.project.mvvm_app.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {
    val apiService = RetrofitInstance.getInstance().create(ApiService::class.java)
    private lateinit var mealsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {

            val categories = apiService.getCategories()
            withContext(Dispatchers.Main) {
                val mealsCategoryRecyclerView =
                    view.findViewById<RecyclerView>(R.id.meals_category_recycler_view)

                val numberOfRows = 2
                val totalItemCount = categories.categories.size

                val columns = if (totalItemCount % numberOfRows == 0) {
                    totalItemCount / numberOfRows
                } else {
                    totalItemCount / numberOfRows + 1
                }
                mealsCategoryRecyclerView.layoutManager =
                    GridLayoutManager(view.context, 2, RecyclerView.HORIZONTAL, false)
                mealsCategoryRecyclerView.adapter = CategoriesAdapter(categories) { categoryId ->

                    CoroutineScope(Dispatchers.IO).launch {
                        val mealsFilter = apiService.filterMealsByCategory(categoryId)
                        withContext(Dispatchers.Main) {
                            mealsRecyclerView = view.findViewById(R.id.meals_recycler_view)

                            val intent = Intent(activity, MealsResultActivity::class.java)
                            intent.putExtra(Constants.MEALS_RESULT, mealsFilter)
                            activity?.startActivity(intent)
                        }
                    }

                }

            }
        }
    }

}