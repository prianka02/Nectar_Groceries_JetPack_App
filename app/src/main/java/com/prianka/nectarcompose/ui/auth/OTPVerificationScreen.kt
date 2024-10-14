package com.prianka.nectarcompose.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.prianka.nectarcompose.ui.components.AuthTopBackground
import com.prianka.nectarcompose.ui.components.CircularArrowButton
import com.prianka.nectarcompose.ui.components.GetOTPView
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme

@Composable
fun OTPVerificationScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
//        Get the reusable TopBackground Component
        AuthTopBackground()

        Spacer(modifier = Modifier.height(30.dp))

        // Get the reusable OTP View Component
        GetOTPView()

        Column(
            modifier = Modifier
                .padding(end = 20.dp, bottom = 50.dp)
                .align(Alignment.BottomEnd),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {

//            Re-usable circular arrow button
            CircularArrowButton(
                onClick = {
//                    // Handle the click event, e.g., navigate to another screen
//                    if ()  {
//
//                    }
//                    else{
//                        navController.navigate(Screen.OTPVerificationScreen.route)
//                    }
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OTPVerificationScreenPreview() {
    NectarComposeTheme {
        OTPVerificationScreen(navController = rememberNavController())
    }
}