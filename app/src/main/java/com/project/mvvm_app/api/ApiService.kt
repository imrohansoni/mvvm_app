package com.project.mvvm_app.api

import com.project.mvvm_app.models.Categories
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): Response<Categories>

//    @GET("lookup.php")
//    suspend fun getMealsById(@Query("i") mealId: String): Meal

//    @GET("search.php")
//    suspend fun getMealsByName(@Query("s") mealName: String): Meals
//
//    @GET("filter.php")
//    suspend fun filterMealsByCategory(@Query("c") categoryName: String): MealsResults
//
//    @GET("filter.php")
//    suspend fun filterByMainIngredient(@Query("i") mainIngredient: String): MealsResults
}