package com.example.amphibians.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.data.Amphibian
import com.example.amphibians.repository.AmphibianRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class AmphibianUiState {
    object Loading : AmphibianUiState()
    data class Success(val data: List<Amphibian>) : AmphibianUiState()
    data class Error(val message: String) : AmphibianUiState()
}

class AmphibianViewModel(
    private val repo: AmphibianRepository = AmphibianRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<AmphibianUiState>(AmphibianUiState.Loading)
    val uiState: StateFlow<AmphibianUiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.value = try {
                AmphibianUiState.Success(repo.fetchAmphibians())
            } catch (t: Throwable) {
                AmphibianUiState.Error(t.localizedMessage ?: "Unknown error")
            }
        }
    }
}

data class Amphibian(
    val name: String,
    val type: String,
    val description: String,
    val imageUrl: String
) 