package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme

@Composable
fun BottomBackgroundDesign() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.bottomblurbackground),
            contentScale = ContentScale.Crop,
            contentDescription = "Top Bar Image",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

