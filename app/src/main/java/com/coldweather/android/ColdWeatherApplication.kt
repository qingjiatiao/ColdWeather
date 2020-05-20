package com.coldweather.android

import android.app.Application
import android.content.Context

class ColdWeatherApplication : Application() {
    companion object{
        const val TOKEN = "1HoxY4mUdNWwjYFC"
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}