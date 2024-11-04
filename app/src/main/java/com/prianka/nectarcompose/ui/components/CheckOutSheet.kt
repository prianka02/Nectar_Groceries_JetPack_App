package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CheckOutSheet(onDismiss: () -> Unit, cartNavController: NavController) {
    val sheetState = rememberModalBottomSheetState()

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val peekHeight = screenHeight * .85f


    ModalBottomSheet(
        onDismissRequest = {
            onDismiss()
        },
        sheetState = sheetState,
        dragHandle = {
            Row(
                modifier = Modifier.fillMaxWidth(.9f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Checkout",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold
                )
                IconButton(
                    onClick = {
                        onDismiss()
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cross_icon),
                        contentDescription = "plus quantity button"
                    )
                }
            }
        }

    ) {
        // Sheet content
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(modifier = Modifier
            .fillMaxWidth(),
            color = colorResource(id = R.color.quantity_border_color)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(.9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Delivery",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.card_gray_text_color)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Select Method",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.arrow_right),
                            contentDescription = ""
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(modifier = Modifier
                    .fillMaxWidth(),
                    color = colorResource(id = R.color.quantity_border_color)
                )
            }
        }

//        Payment component
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(.9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Payment",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.card_gray_text_color)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.payment_card),
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.arrow_right),
                            contentDescription = ""
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(modifier = Modifier
                    .fillMaxWidth(),
                    color = colorResource(id = R.color.quantity_border_color)
                )
            }
        }

//        Promo code
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(.9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Promo Code",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.card_gray_text_color)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Pick discount",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.arrow_right),
                            contentDescription = ""
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(modifier = Modifier
                    .fillMaxWidth(),
                    color = colorResource(id = R.color.quantity_border_color)
                )
            }
        }
//        Total Cost
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(.9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total Cost",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.card_gray_text_color)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$13.97",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.arrow_right),
                            contentDescription = ""
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(modifier = Modifier
                    .fillMaxWidth(),
                    color = colorResource(id = R.color.quantity_border_color)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(start = 25.dp),
            text = "By placing an order you agree to our\n" +
                    "Terms And Conditions",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.card_gray_text_color)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            NectarDesignerButton(
                text = "Place Order",
                onClick = {
                    cartNavController.navigate("PlaceOrderScreen")
                }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

    }
}


@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    NectarComposeTheme {
        CheckOutSheet(
            onDismiss = {},
            rememberNavController()
        )
    }
}