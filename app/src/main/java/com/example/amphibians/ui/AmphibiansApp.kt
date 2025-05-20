package com.example.amphibians.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.amphibians.viewmodel.AmphibianUiState
import com.example.amphibians.viewmodel.AmphibianViewModel

@Composable
fun AmphibiansApp(viewModel: AmphibianViewModel) {
    when (val state = viewModel.uiState.collectAsState().value) {
        is AmphibianUiState.Loading -> { /* show a spinner */ }
        is AmphibianUiState.Error   -> { /* show retry button + message */ }
        is AmphibianUiState.Success -> AmphibianList(state.data)
    }
} 