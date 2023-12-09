package com.project.mvvm_app.models

import android.os.Parcel
import android.os.Parcelable

data class MealResult(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(idMeal)
        parcel.writeString(strMeal)
        parcel.writeString(strMealThumb)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MealResult> {
        override fun createFromParcel(parcel: Parcel): MealResult {
            return MealResult(parcel)
        }

        override fun newArray(size: Int): Array<MealResult?> {
            return arrayOfNulls(size)
        }
    }
}