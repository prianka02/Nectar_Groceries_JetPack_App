package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.prianka.nectarcompose.R

@Composable
fun AuthTopBackground(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.3f)
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.authtopbackground),
            contentScale = ContentScale.Crop,
            contentDescription = "Top Bar Image",
            modifier = Modifier.fillMaxWidth()
        )

        // Icon image
        Image(
            painter = painterResource(id = R.drawable.backicon),
            contentDescription = "Back Icon",
            modifier = Modifier
                .padding(top = 30.dp, start = 10.dp)
        )
    }
}