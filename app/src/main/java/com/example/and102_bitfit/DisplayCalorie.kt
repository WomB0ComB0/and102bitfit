package com.example.and102_bitfit

class DisplayCalorie(
    val food: String?,
    val calories: String?,
    private val id: Long
) {
    override fun toString(): String {
        return "DisplayCalorie(food='$food', calories=$calories, id=$id)"
    }
}