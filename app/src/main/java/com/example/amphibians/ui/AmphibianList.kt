package com.example.amphibians.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.amphibians.data.Amphibian

@Composable
fun AmphibianList(amphibians: List<Amphibian>) {
    LazyColumn {
        items(amphibians) { amph ->
            AmphibianCard(amphibian = amph)
        }
    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(amphibian.name, style = MaterialTheme.typography.h6)
            Text(amphibian.type, style = MaterialTheme.typography.subtitle2)
            Spacer(Modifier.height(8.dp))
            AsyncImage(
                model = amphibian.imgSrc,
                contentDescription = amphibian.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(amphibian.description, style = MaterialTheme.typography.body2)
        }
    }
} 