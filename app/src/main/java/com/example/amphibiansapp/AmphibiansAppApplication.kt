package com.example.amphibiansapp

import android.app.Application
import com.example.amphibiansapp.container.AppContainer
import com.example.amphibiansapp.container.DefaultAppContainer
import com.example.amphibiansapp.data.AmphibianRepository

/**
 * Custom Application to expose the AppContainer
 */
class AmphibiansAppApplication : Application(), AppContainer {
    private lateinit var container: AppContainer
    override val amphibianRepository: AmphibianRepository
        get() = container.amphibianRepository

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
} 