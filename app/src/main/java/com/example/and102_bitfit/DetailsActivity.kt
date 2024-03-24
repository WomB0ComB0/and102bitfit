package com.example.and102_bitfit

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "DetailActivity"

class DetailsActivity : AppCompatActivity() {
    private lateinit var foodTextView: TextView
    private lateinit var calorieTextView: TextView
    private lateinit var dateImageView: ImageView
    private lateinit var timeTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        foodTextView = findViewById(R.id.food)
        calorieTextView = findViewById(R.id.calorie)
        dateImageView = findViewById(R.id.date)
        timeTextView = findViewById(R.id.time)

        val calorie = intent.getSerializableExtra(ARTICLE_EXTRA) as DisplayCalorie

        // Set title and abstract information for the article
        foodTextView.text = calorie.food

    }
}