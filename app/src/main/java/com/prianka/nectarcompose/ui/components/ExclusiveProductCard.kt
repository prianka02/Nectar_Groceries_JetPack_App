package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.home.ProductDetailsScreen

@Composable
fun ExclusiveProductCard(
    productName: String,
    productQuantity: String,
    productPrice: String,
    productImage: Painter,
    shopNavController: NavHostController,
    onAddClick: () -> Unit
) {
    OutlinedCard(
        modifier = Modifier
            .width(173.dp)
            .height(248.dp)
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, color = colorResource(id = R.color.nectar_gray_color)),
        onClick = {
            shopNavController.navigate("DetailScreen")
        }
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)

        ) {

            Spacer(modifier = Modifier.height(8.dp))
            // Product Image
            Image(
                painter = productImage,
                contentDescription = null,
                modifier = Modifier
                    .height(62.dp)
                    .width(103.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(13.dp))

            // Product Name
            Text(
                text = productName,
                maxLines = 1,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.card_black_text_color)
            )

            // Product Quantity/Weight
            Text(
                text = "$productQuantity Price g",
                color = colorResource(id = R.color.card_gray_text_color),
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Product Price
                Text(
                    text = productPrice,
                    fontSize = 17.sp,
                    color = colorResource(id = R.color.card_black_text_color),
                    fontWeight = FontWeight.SemiBold,
                )
                // Add to Cart Button
                Box(
                    modifier = Modifier
                        .width(45.dp)
                        .height(45.dp)
                        .clip(RoundedCornerShape(17.dp))
                        .background(Color.Transparent),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        modifier = Modifier
                            .clickable { onAddClick() }
                            .width(45.dp)
                            .height(45.dp),
                        painter = painterResource(id = R.drawable.add_button_logo),
                        contentDescription = "Add to Cart Button"
                    )
                }
            }
        }
    }
}