package com.dowpro.marketapp

import androidx.multidex.MultiDexApplication
import com.google.android.material.color.DynamicColors
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        // https://github.com/material-components/material-components-android/blob/master/docs/theming/Color.md
        // Apply dynamic colors, DayNight, to all activities in the app
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}
