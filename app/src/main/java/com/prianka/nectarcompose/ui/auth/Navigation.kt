package com.prianka.nectarcompose.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme

@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SignInScreen.route) {
        composable(route = Screen.SignInScreen.route){
            SignInScreen( navController )
        }
        composable(route = Screen.MobileNumberScreen.route){
            MobileNumberScreen(navController)
        }
        composable(route = Screen.OTPVerificationScreen.route){
            OTPVerificationScreen(navController)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NavigationPreview() {
    NectarComposeTheme {
     }
}