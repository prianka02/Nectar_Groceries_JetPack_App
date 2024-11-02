package com.prianka.nectarcompose.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.components.AuthTopBackground
import com.prianka.nectarcompose.ui.components.CircularArrowButton
import com.prianka.nectarcompose.ui.components.GetOTPView
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme

@Composable
fun OTPVerificationScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AuthTopBackground(navController)     // Get the reusable TopBackground Component

        GetOTPView()     // Get the reusable OTP View Component

        Box(
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.BottomEnd)
                .imePadding() // Automatically adjust padding when keyboard appears

        ) {
            //  Resend Button
            Column(
                modifier = Modifier
                    .padding(end = 20.dp, bottom = 50.dp)
                    .align(Alignment.BottomStart),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "Resend Code",
                    color = colorResource(id = R.color.nectar_primary_color),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(start = 20.dp, bottom = 20.dp)
                )
            }
            //    Traverse Next Navigation Button
            Column(
                modifier = Modifier
                    .padding(end = 20.dp, bottom = 50.dp)
                    .align(Alignment.BottomEnd),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {

                //   Re-usable circular arrow button
                CircularArrowButton(
                    onClick = {
                        // Handle the click event, e.g., navigate to another screen
                        navController.navigate(Screen.LocationScreen.route)
                    }
                )
            }
        }
    }
}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun OTPVerificationScreenPreview() {
//    NectarComposeTheme {
//        OTPVerificationScreen(navController = rememberNavController())
//    }
//}