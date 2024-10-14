package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.prianka.nectarcompose.R // Adjust according to your package structure

@Composable
fun CircularArrowButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(56.dp) // Set size for the circular button
            .clip(CircleShape) // Clip the box to make it circular
            .clickable { onClick() } // Handle click events
            .background(Color.Transparent) // Optional: background color
    ) {
        Image(
            painter = painterResource(id = R.drawable.floatingnext), // Replace with your image resource name
            contentDescription = "Arrow Image",
            modifier = Modifier
                .size(56.dp) // Same size as the box
        )
    }
}

