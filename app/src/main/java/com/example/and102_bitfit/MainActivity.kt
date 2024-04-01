package com.example.and102_bitfit

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val calorie = mutableListOf<DisplayCalorie>()
    private lateinit var calorieRecyclerView: RecyclerView
    private lateinit var calorieAdapter: CalorieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var changeView = findViewById<Button>(R.id.add_calories)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        calorieRecyclerView = findViewById(R.id.rv_calories)
        calorieAdapter = CalorieAdapter(this, calorie)

        calorieRecyclerView.adapter = calorieAdapter
        calorieRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            calorieRecyclerView.addItemDecoration(dividerItemDecoration)
        }
        lifecycleScope.launch {
            (application as CalorieApplication).db.calorieDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    DisplayCalorie(
                        entity.food,
                        entity.calorie,
                        entity.id
                    )
                }.also { mappedList ->
                    calorie.clear()
                    calorie.addAll(mappedList)
                    calorieAdapter.run { notifyDataSetChanged() }
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}