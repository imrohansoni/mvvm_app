package com.project.mvvm_app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.mvvm_app.R
import com.project.mvvm_app.api.ApiService
import com.project.mvvm_app.api.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val apiService = RetrofitInstance.getInstance().create(ApiService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val categories = apiService.getCategories()
            for (category in categories.categories) {
                Log.i("Categories", category.toString())
            }
        }

        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}