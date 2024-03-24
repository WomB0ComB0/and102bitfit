package com.example.and102_bitfit

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Calorie(
    @SerialName("food")
    val food: String?,
    @SerialName("calories")
    val calories: Int?,
    @SerialName("date")
    val date: String?,
    @SerialName("time")
    val time: String?,
    @SerialName("id")
    val id: Int?
) : java.io.Serializable