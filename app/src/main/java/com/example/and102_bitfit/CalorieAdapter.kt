package com.example.and102_bitfit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

const val ARTICLE_EXTRA = "CALORIE_EXTRA"
private const val TAG = "CalorieAdapter"

class CalorieAdapter (private val context: Context, private val calories: List<Calorie>) :
    RecyclerView.Adapter<CalorieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_calorie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val calorie = calories[position]
        holder.bind(calorie)
    }

    override fun getItemCount() = calories.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val foodTextView = itemView.findViewById<TextView>(R.id.food)
        private val calorieTextView = itemView.findViewById<TextView>(R.id.calorie)
        private val dateTextView = itemView.findViewById<TextView>(R.id.date)
        private val timeTextView = itemView.findViewById<TextView>(R.id.time)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(calorie: Calorie) {
            foodTextView.text = calorie.food
            calorieTextView.text = calorie.calories.toString()
            dateTextView.text = calorie.date
            timeTextView.text = calorie.time
        }

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val calorie = calories[position]
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra(ARTICLE_EXTRA, calorie)
                context.startActivity(intent)
            }
        }
    }
}