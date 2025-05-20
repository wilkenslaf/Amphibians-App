package com.example.amphibiansapp.data

import com.example.amphibiansapp.network.AmphibianApiService
import com.example.amphibiansapp.model.Amphibian

/**
 * Data layer: repository interface and network implementation
 */
interface AmphibianRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibianRepository(
    private val service: AmphibianApiService
) : AmphibianRepository {
    override suspend fun getAmphibians(): List<Amphibian> = service.getAmphibians()
} 