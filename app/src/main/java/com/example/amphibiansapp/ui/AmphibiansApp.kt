package com.example.amphibiansapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.amphibiansapp.model.Amphibian
import com.example.amphibiansapp.viewmodel.AmphibianUiState
import com.example.amphibiansapp.viewmodel.AmphibianViewModel

@Composable
fun AmphibiansApp(viewModel: AmphibianViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    when (uiState) {
        is AmphibianUiState.Loading -> LoadingScreen()
        is AmphibianUiState.Error -> ErrorScreen((uiState as AmphibianUiState.Error).message)
        is AmphibianUiState.Success -> AmphibianList((uiState as AmphibianUiState.Success).data)
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Failed to load amphibians")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = message)
        }
    }
}

@Composable
fun AmphibianList(amphibians: List<Amphibian>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(amphibians) { amph ->
            AmphibianCard(amph)
        }
    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(amphibian.name, style = MaterialTheme.typography.titleMedium)
            Text(amphibian.type, style = MaterialTheme.typography.bodySmall)
            Spacer(Modifier.height(8.dp))
            AsyncImage(
                model = amphibian.imgSrc,
                contentDescription = amphibian.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(amphibian.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
} 