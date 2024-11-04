package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prianka.nectarcompose.R

@Composable
fun AuthTopBackground(navController: NavController, keyboardController: SoftwareKeyboardController?) {
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
        IconButton(
            onClick = {
                keyboardController?.hide()  // Hide the keyboard
                navController.navigateUp()
            },
            modifier = Modifier
                .padding(top = 50.dp, start = 5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.backicon),
                contentDescription = "Back Icon"
            )
        }

    }
}