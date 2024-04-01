package com.example.and102_bitfit

class Calorie(
    val food: String?,
    val calories: String?,
    private val id: Long
) {
    override fun toString(): String {
        return "Calorie(food='$food', calories=$calories, id=$id)"
    }
}