package com.example.EasyCar

import android.app.Application
import com.example.EasyCar.data.CarDatabase

class BaseApplication : Application() {
    val database: CarDatabase by lazy { CarDatabase.getDatabase(this) }
}