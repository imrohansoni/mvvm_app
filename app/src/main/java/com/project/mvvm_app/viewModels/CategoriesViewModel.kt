package com.project.mvvm_app.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.mvvm_app.api.ApiService
import com.project.mvvm_app.api.RetrofitInstance
import com.project.mvvm_app.models.Category
import kotlinx.coroutines.launch

class CategoriesViewModel : ViewModel() {
    private lateinit var _categories: MutableLiveData<List<Category>>
    val categories: LiveData<List<Category>> get() = _categories

    fun fetchCategories() {
        viewModelScope.launch {
            val apiService = RetrofitInstance.getInstance().create(ApiService::class.java)
            try {
                val response = apiService.getCategories()
                if (response.isSuccessful && response.body() != null) {
                    _categories.value = response.body()!!.categories
                }
            } catch (err: Exception) {
                throw Exception(err.message)
            }
        }
    }

}