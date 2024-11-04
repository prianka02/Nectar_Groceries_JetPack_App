package com.prianka.nectarcompose.ui.auth

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun VerificationNavHost() {
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
        composable(route = Screen.LocationScreen.route){
            LocationScreen(navController)
        }
        composable(route = Screen.EmailLoginScreen.route){
            EmailLoginScreen(navController)
        }
        composable(route = Screen.SignUpScreen.route){
            SignUpScreen(navController)
        }

    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun NavigationPreview() {
//    NectarComposeTheme {
//     }
//}