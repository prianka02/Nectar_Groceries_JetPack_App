package com.prianka.nectarcompose.ui.auth

sealed class Screen(val route: String) {
    data object SignInScreen : Screen("sign_in_screen")
    data object MobileNumberScreen : Screen("mobile_number_screen")
    data object OTPVerificationScreen : Screen("verification_screen")
    data object LocationScreen : Screen("location_screen")
//    data object SignUpScreen : Screen("sign_up_screen")
}