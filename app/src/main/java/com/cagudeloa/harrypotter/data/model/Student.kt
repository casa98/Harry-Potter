package com.cagudeloa.harrypotter.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Student(
    val actor: String = "",
    val ancestry: String = "",
    val dateOfBirth: String = "",
    val eyeColour: String = "",
    val house: String = "",
    val image: String = "",
    val name: String = "",
    val patronus: String = "",
    val species: String = "",
): Parcelable