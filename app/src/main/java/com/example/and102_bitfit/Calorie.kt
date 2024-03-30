package com.example.and102_bitfit

class Calorie(
    private val food: String,
    private val calories: Int,
    private val id: Int?
) {
    override fun toString(): String {
        return "Calorie(food='$food', calories=$calories, id=$id)"
    }
}