package com.project.mvvm_app.api

import com.project.mvvm_app.models.Categories
import com.project.mvvm_app.models.Meal
import com.project.mvvm_app.models.Meals
import com.project.mvvm_app.models.MealsResults
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): Categories

    @GET("lookup.php")
    suspend fun getMealsById(@Query("i") mealId: String): Meal

    @GET("search.php")
    suspend fun getMealsByName(@Query("s") mealName: String): Meals

    @GET("filter.php")
    suspend fun filterMealsByCategory(@Query("c") categoryName: String): MealsResults

    @GET("filter.php")
    suspend fun filterByMainIngredient(@Query("i") mainIngredient: String): MealsResults
}