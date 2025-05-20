package com.example.amphibiansapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.amphibiansapp.ui.AmphibiansApp
import com.example.amphibiansapp.viewmodel.AmphibianViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    private val viewModel: AmphibianViewModel by viewModels {
        AmphibianViewModel.provideFactory((application as AmphibiansAppApplication).amphibianRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibiansApp(viewModel)
        }
    }
}