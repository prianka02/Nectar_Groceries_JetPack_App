package com.prianka.nectarcompose.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme
import com.prianka.nectarcompose.ui.viewmodels.SharedLocationViewModel

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NectarComposeTheme {
                val sharedLocationViewModel: SharedLocationViewModel = viewModel() // Shared instance

                BottomNavigationScreen(sharedLocationViewModel)
            }
        }
    }
}

