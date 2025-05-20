package com.example.amphibiansapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.amphibiansapp.data.AmphibianRepository
import com.example.amphibiansapp.model.Amphibian
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * Sealed UI state for loading, success, and error
 */
sealed interface AmphibianUiState {
    object Loading : AmphibianUiState
    data class Success(val data: List<Amphibian>) : AmphibianUiState
    data class Error(val message: String) : AmphibianUiState
}

class AmphibianViewModel(
    private val repository: AmphibianRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<AmphibianUiState>(AmphibianUiState.Loading)
    val uiState: StateFlow<AmphibianUiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.value = try {
                AmphibianUiState.Success(repository.getAmphibians())
            } catch (e: IOException) {
                AmphibianUiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }

    companion object {
        fun provideFactory(
            repository: AmphibianRepository
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(AmphibianViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return AmphibianViewModel(repository) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
            }
        }
    }
} 