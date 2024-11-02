package com.prianka.nectarcompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.components.HorizontalDividerComponent
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme

@Composable
fun FavouriteScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Favourite",
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp
        )

        Spacer(modifier = Modifier.height(25.dp))
        HorizontalDividerComponent()
        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(.9f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(90.dp)
                        .height(74.dp),
                    painter = painterResource(id = R.drawable.sprite),
                    contentDescription = ""
                )

                Column(
                ) {
                    Text(
                        text = "Sprite Can",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )


                    Text(
                        text = "325ml, Price",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.nectar_gray_text_color)
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$1.50",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "bell chicken red"
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(.9f),
            color = colorResource(id = R.color.quantity_border_color)
        )



        Box(
            modifier = Modifier.fillMaxHeight(.9f),
            contentAlignment = Alignment.BottomCenter
        ){
            FloatingActionButton(
                modifier = Modifier.fillMaxWidth(.9f)
                    .clip(RoundedCornerShape(19.dp)),
                onClick =  {},
                containerColor = colorResource(id = R.color.nectar_primary_color),
                contentColor = Color.White
            ) {
                Text(
                    text = "Add All To Cart",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        LazyColumn {

        }
    }
}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun CartScreenPreview() {
//    NectarComposeTheme {
//        FavouriteScreen()
//    }
//}