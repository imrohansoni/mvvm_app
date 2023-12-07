package com.project.mvvm_app.api

import com.project.mvvm_app.models.Categories
import com.project.mvvm_app.models.MealDetails
import com.project.mvvm_app.models.Meals
import com.project.mvvm_app.models.MealsFilter
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): Categories

    @GET("lookup.php?i={mealId}")
    suspend fun getMealsById(@Query("mealId") mealId: String): MealDetails

    @GET("search.php?s={mealName}")
    suspend fun getMealsByName(@Query("mealName") mealName: String): Meals

    @GET("filter.php?c={categoryName}")
    suspend fun filterMealsByCategory(@Query("categoryName") categoryName: String): MealsFilter

    @GET("filter.php?i={mainIngredient}")
    suspend fun filterByMainIngredient(@Query("mainIngredient") mainIngredient: String): MealsFilter
}