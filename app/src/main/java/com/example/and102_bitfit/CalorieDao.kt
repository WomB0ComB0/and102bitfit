package com.example.and102_bitfit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CalorieDao {
    @Query("SELECT * FROM calorie_table")
    fun getAll(): Flow<List<CalorieEntity>>

    @Insert
    fun insertAll(calories: List<CalorieEntity>)

    @Query("DELETE FROM calorie_table")
    fun deleteAll()
}