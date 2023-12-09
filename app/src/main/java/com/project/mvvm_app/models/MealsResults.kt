package com.project.mvvm_app.models

import android.os.Parcel
import android.os.Parcelable

data class MealsResults(
    val mealResults: List<MealResult>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(MealResult.CREATOR) ?: emptyList()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(mealResults)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MealsResults> {
        override fun createFromParcel(parcel: Parcel): MealsResults {
            return MealsResults(parcel)
        }

        override fun newArray(size: Int): Array<MealsResults?> {
            return arrayOfNulls(size)
        }
    }
}