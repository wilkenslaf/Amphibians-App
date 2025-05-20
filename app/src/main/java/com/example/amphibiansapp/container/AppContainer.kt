package com.example.amphibiansapp.container

import com.example.amphibiansapp.data.AmphibianRepository
import com.example.amphibiansapp.data.NetworkAmphibianRepository
import com.example.amphibiansapp.network.AmphibianApi

/**
 * Application container for dependency injection
 */
interface AppContainer {
    val amphibianRepository: AmphibianRepository
}

class DefaultAppContainer : AppContainer {
    private val apiService by lazy { AmphibianApi.service }
    override val amphibianRepository: AmphibianRepository by lazy {
        NetworkAmphibianRepository(apiService)
    }
} 