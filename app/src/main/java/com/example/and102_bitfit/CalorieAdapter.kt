package com.example.and102_bitfit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

const val ARTICLE_EXTRA = "CALORIE_EXTRA"
private const val TAG = "CalorieAdapter"

class CalorieAdapter (private val context: Context, private val calories: MutableList<DisplayCalorie>) :
    RecyclerView.Adapter<CalorieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val calories = calories[position]
        holder.bind(calories)
    }

    override fun getItemCount() = calories.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val foodTextView = itemView.findViewById<TextView>(R.id.calorieName)
        private val calorieTextView = itemView.findViewById<TextView>(R.id.calorieAmount)

        fun bind(calorie: DisplayCalorie) {
            foodTextView.text = calorie.food
            calorieTextView.text = calorie.calories.toString()
        }
    }
}