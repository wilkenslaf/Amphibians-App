package com.example.amphibians

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.amphibians.ui.AmphibiansApp
import com.example.amphibians.viewmodel.AmphibianViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: AmphibianViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibiansApp(viewModel)
        }
    }
}