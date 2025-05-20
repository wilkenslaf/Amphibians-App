package com.example.amphibians.repository

import com.example.amphibians.data.Amphibian
import com.example.amphibians.network.AmphibianApi

class AmphibianRepository {
    suspend fun fetchAmphibians(): List<Amphibian> =
        AmphibianApi.service.getAmphibians()
} 