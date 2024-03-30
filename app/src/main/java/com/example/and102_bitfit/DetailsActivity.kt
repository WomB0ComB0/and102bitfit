package com.example.and102_bitfit

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "DetailActivity"

class DetailsActivity : AppCompatActivity() {
    private lateinit var foodTextView: TextView
    private lateinit var calorieTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        foodTextView = findViewById(R.id.calorieName)
        calorieTextView = findViewById(R.id.calorieAmount)

        val calorie = intent.getSerializableExtra(ARTICLE_EXTRA) as DisplayCalorie

        foodTextView.text = calorie.food
        calorieTextView.text = calorie.calories.toString()
    }
}