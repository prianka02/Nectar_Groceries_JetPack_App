package com.prianka.nectarcompose.ui.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme

class VerificationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NectarComposeTheme {
                    Navigation()
            }
        }
    }
}

