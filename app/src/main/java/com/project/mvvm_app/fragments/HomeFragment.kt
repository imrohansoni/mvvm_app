package com.project.mvvm_app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.mvvm_app.R
import com.project.mvvm_app.adapters.CategoriesAdapter
import com.project.mvvm_app.api.ApiService
import com.project.mvvm_app.api.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)


        val apiService = RetrofitInstance.getInstance().create(ApiService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val categories = apiService.getCategories()
            withContext(Dispatchers.Main) {
                view.findViewById<RecyclerView>(R.id.meals_category_recycler_view).let {
                    val numberOfRows = 2
                    val totalItemCount = categories.categories.size

                    val columns = if (totalItemCount % numberOfRows == 0) {
                        totalItemCount / numberOfRows
                    } else {
                        totalItemCount / numberOfRows + 1
                    }

                    it.layoutManager = GridLayoutManager(view.context, 2, RecyclerView.HORIZONTAL, false)
                    it.adapter = CategoriesAdapter(categories)
                }
            }
        }
        return view
    }
}