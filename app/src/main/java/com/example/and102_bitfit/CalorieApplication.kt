package com.example.and102_bitfit

import android.app.Application

class CalorieApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}
