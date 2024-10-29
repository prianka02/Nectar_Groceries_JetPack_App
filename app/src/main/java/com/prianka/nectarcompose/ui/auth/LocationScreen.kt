package com.prianka.nectarcompose.ui.auth

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.components.AuthTopBackground
import com.prianka.nectarcompose.ui.components.BottomBackgroundDesign
import com.prianka.nectarcompose.ui.components.LocationDropDown
import com.prianka.nectarcompose.ui.components.NectarDesignerButton
import com.prianka.nectarcompose.ui.home.HomeActivity

@Composable
fun LocationScreen(navController: NavController) {
    val context = LocalContext.current // Get the current context

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Top Background Component
            AuthTopBackground(navController)

            // Content in the middle
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.5f)
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter), // Align the content in the bottom half
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.map),
                        contentDescription = "Map Icon",
                    )
                    Spacer(modifier = Modifier.height(50.dp))

                    Text(
                        text = "Select Your Location",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Switch on your location to stay in tune with\n what’s happening in your area",
                        fontSize = 15.sp,
                        color = colorResource(id = R.color.nectar_gray_text_color),
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(80.dp))

//      Bottom Components Design of Dropdowns
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment =  Alignment.BottomCenter
            ) {

            BottomBackgroundDesign()

//          Location Selection Dropdown Components
            val zoneList = listOf("Types of your Zone", "Banasree", "Banani", "Gulshan", "Dhanmondi", "Mirpur", "Uttara", "Mohammadpur")
            val zoneCurrentValue = remember { mutableStateOf(zoneList[0]) }

            val areaList = listOf("Types of your area", "Block A", "Block B", "Block C", "Block D", "Block E", "Block F", "Block G")
            val areaCurrentValue = remember { mutableStateOf(areaList[0]) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                LocationDropDown(
                    label = "Your Zone",
                    itemList = zoneList,
                    selectedItem = zoneCurrentValue
                )
//              Spacer between two dropdowns
                Spacer(modifier = Modifier.height(20.dp))
                LocationDropDown(
                    label = "Your Area",
                    itemList = areaList,
                    selectedItem = areaCurrentValue
                )
            }

            Box(
                modifier = Modifier
                    .padding(bottom = 65.dp)
            ) {
                NectarDesignerButton(
                    text = "Submit",
                    onClick = {
                        val intent = Intent(context, HomeActivity::class.java)
                        context.startActivity(intent)
                    }
                )}
            }
    }
}

//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LocationScreenPreview() {
//    NectarComposeTheme {
//        LocationScreen()
//    }
//}