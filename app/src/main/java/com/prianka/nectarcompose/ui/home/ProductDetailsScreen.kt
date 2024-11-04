package com.prianka.nectarcompose.ui.home

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.components.DetailsPageSlider
import com.prianka.nectarcompose.ui.components.HorizontalDividerComponent
import com.prianka.nectarcompose.ui.components.NectarDesignerButton

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductDetailsScreen(shopNavController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
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

            Box(
                modifier = Modifier.fillMaxSize()
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ){
                DetailsPageSlider()

            }

        }
        //        Item quantity identification
        Row(
            modifier = Modifier.fillMaxWidth(.9f)
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Naturel Red Apple",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
            )

            IconButton(
                onClick = {

                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bookmarkicon),
                    contentDescription = " Item Book mark Icon"
                )
            }
        }
        Text(
            modifier = Modifier.padding(start = 24.dp),
            text = "1kg, Price",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.card_gray_text_color)
        )
        //   Quantity Up Down part
        Row(
            modifier = Modifier.fillMaxWidth(.9f)
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {

                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.minus_quantity),
                        contentDescription = "minus quantity button"
                    )
                }
                Box( modifier = Modifier
                    .size(45.dp)
                    .border(
                        width = 1.dp,
                        color = colorResource(id = R.color.quantity_border_color),
                        shape = RoundedCornerShape(17.dp)
                    )
                ){
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "1",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                IconButton(
                    onClick = {

                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plus_quantity),
                        contentDescription = "plus quantity button"
                    )
                }
            }
            Text(
                text = "$4.99",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(25.dp))
        HorizontalDivider(
            color = colorResource(id = R.color.nectar_gray_color),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth(.9f)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(25.dp))

        // Add to Cart Button
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ){
            NectarDesignerButton(
                text = "Add To Basket",
                onClick = {

                }
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductDetailsScreenPreview(){
    ProductDetailsScreen(
        shopNavController = rememberNavController()
    )
}