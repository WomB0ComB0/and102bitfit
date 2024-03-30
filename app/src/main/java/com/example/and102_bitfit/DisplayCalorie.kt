package com.example.and102_bitfit

class DisplayCalorie(
    val food: String,
    val calories: Int,
    private val id: Int?
) {
    override fun toString(): String {
        return "DisplayCalorie(food='$food', calories=$calories, id=$id)"
    }
}