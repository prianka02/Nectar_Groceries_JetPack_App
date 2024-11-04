package com.prianka.nectarcompose.ui.auth

sealed class Screen(val route: String) {
    data object SplashScreen : Screen("splash")
    data object OnBoardingScreen : Screen("onBoarding")
    data object VerificationNavHost : Screen("verification_nav")
    data object SignInScreen : Screen("sign_in_screen")
    data object MobileNumberScreen : Screen("mobile_number_screen")
    data object OTPVerificationScreen : Screen("verification_screen")
    data object LocationScreen : Screen("location_screen")
    data object EmailLoginScreen : Screen("email_login_screen")
    data object SignUpScreen : Screen("signup_screen")
}