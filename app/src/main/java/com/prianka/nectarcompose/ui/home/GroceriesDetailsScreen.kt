package com.prianka.nectarcompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.prianka.nectarcompose.R


@Composable
fun GroceriesDetailsScreen(shopNavController: NavHostController) {

    Column {
        Box(
            modifier = Modifier
                .fillMaxHeight(.45f)
                .fillMaxWidth()
        ) {
            // Background image
            Image(
                painter = painterResource(id = R.drawable.topdetailspic),
                contentScale = ContentScale.Crop,
                contentDescription = "Top Bar details Image",
                modifier = Modifier.fillMaxWidth()
            )

            // Fruit Blur Background image
            Image(
                painter = painterResource(id = R.drawable.fruitblurbackground),
                contentScale = ContentScale.Crop,
                contentDescription = "Top Bar fruit blur background",
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.Center)
            )

            // Back Icon image
            IconButton(
                onClick = {
                    shopNavController.navigateUp()
                },
                modifier = Modifier
                    .padding(top = 50.dp, start = 5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.backicon),
                    contentDescription = "Back Icon"
                )
            }

            // Download image Icon
            IconButton(
                onClick = {

                },
                modifier = Modifier
                    .padding(top = 50.dp, end = 5.dp)
                    .align(Alignment.TopEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.downloadicon),
                    contentDescription = "Download Image Icon"
                )
            }

        }
    }
}