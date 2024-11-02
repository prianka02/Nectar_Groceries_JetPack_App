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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.components.CheckOutSheet
import com.prianka.nectarcompose.ui.components.HorizontalDividerComponent

@Composable
fun CartMainScreen(modifier: Modifier = Modifier,
                   cartNavController: NavController
){
    var showBottomSheet by remember { mutableStateOf(false) }


    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "My Cart",
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp
        )

        Spacer(modifier = Modifier.height(25.dp))
        HorizontalDividerComponent()

        Column(
            modifier = Modifier.fillMaxWidth(.9f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier
                        .width(90.dp)
                        .height(74.dp),
                    painter = painterResource(id = R.drawable.bell_paper_red),
                    contentDescription = "bell chicken red"
                )

                Spacer(modifier = Modifier.width(25.dp))

                Column(
                ) {
                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Bell Pepper Red",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cross_sign),
                                contentDescription = "delete item from cart"
                            )
                        }
                    }

                    Text(
                        text = "1kg, Price",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.nectar_gray_text_color)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box( modifier = Modifier
                                .size(45.dp)
                                .border(
                                    width = 1.dp,
                                    color = colorResource(id = R.color.quantity_border_color),
                                    shape = RoundedCornerShape(17.dp)
                                )
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
                            }

                            Text(
                                modifier = Modifier.padding(20.dp),
                                text = "1",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Box( modifier = Modifier
                                .size(45.dp)
                                .border(
                                    width = 1.dp,
                                    color = colorResource(id = R.color.quantity_border_color),
                                    shape = RoundedCornerShape(17.dp)
                                )
                            ){
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
                        }

                        Text(
                            text = "$4.99",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            HorizontalDivider(modifier = Modifier
                .fillMaxWidth(),
                color = colorResource(id = R.color.quantity_border_color)
            )
        }

        Box(
            modifier = Modifier.fillMaxHeight(.9f),
            contentAlignment = Alignment.BottomCenter
        ){
            FloatingActionButton(
                modifier = Modifier.fillMaxWidth(.9f)
                    .clip(RoundedCornerShape(19.dp)),
                onClick =  {
                    showBottomSheet = true
                },
                containerColor = colorResource(id = R.color.nectar_primary_color),
                contentColor = Color.White
            ) {
                Text(
                    text = "Go to Checkout",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .padding(end = 20.dp),
                    contentAlignment = Alignment.CenterEnd
                )
                {
                    Box(modifier = Modifier
                        .height(20.dp)
                        .width(50.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFF489E67)),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "$12.96",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        if (showBottomSheet) {
            CheckOutSheet(
                onDismiss = { showBottomSheet = false },
                cartNavController
                )
        }




        LazyColumn {

        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun CartScreenPreview() {
//    NectarComposeTheme {
//        CartMainScreen()
//    }
//}