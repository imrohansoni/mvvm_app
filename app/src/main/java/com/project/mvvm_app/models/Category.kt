package com.project.mvvm_app.models

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strCategoryDescription")
    val description: String,
    @SerializedName("strCategoryThumb")
    val thumb: String
)