package com.example.newsapp

import android.app.Application
import android.content.res.Configuration

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        applyDarkTheme()
    }

    private fun applyDarkTheme() {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_YES -> {
                setTheme(R.style.Base_Theme_NewsApp_Dark)
            }

            Configuration.UI_MODE_NIGHT_NO -> {
                setTheme(R.style.Base_Theme_NewsApp)
            }
        }
    }
}