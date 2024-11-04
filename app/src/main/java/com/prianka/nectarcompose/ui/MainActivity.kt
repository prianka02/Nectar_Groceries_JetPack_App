package com.prianka.nectarcompose.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.datastore.DatastoreManager
import com.prianka.nectarcompose.ui.auth.Screen
import com.prianka.nectarcompose.ui.auth.VerificationNavHost
import com.prianka.nectarcompose.ui.components.NectarDesignerButton
import com.prianka.nectarcompose.ui.home.HomeActivity
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        // This line allows your app to draw behind system bars
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            NectarComposeTheme {
                MainNavigation()
            }
        }
    }
}

// this is the SplashNavigation Composable function that sets up the navigation graph for the splash screen
@Composable
fun MainNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route){
        composable(Screen.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(Screen.OnBoardingScreen.route){
            OnBoardingScreen(navController)
        }
        composable(Screen.VerificationNavHost.route){
            VerificationNavHost()
        }
    }
}

// SplashScreen Composable function that displays the splash screen
@Composable
fun SplashScreen(navController: NavController){
    val context = LocalContext.current


    val datastoreManager = DatastoreManager(context)

    // Collect the mobile number from the datastore
    val userMobile = datastoreManager.getString("user_mobile", "").collectAsState(initial = null).value

    // Start a coroutine for the splash delay and navigation
    LaunchedEffect(key1 = userMobile) {

        kotlinx.coroutines.delay(2000)

        if (!userMobile.isNullOrEmpty()) {

            context.startActivity(Intent(context, HomeActivity::class.java))   // Mobile number exists, navigate to HomeActivity
            (context as? ComponentActivity)?.finish()       // Finish SplashScreen to prevent going back
        }
        else {
            // Mobile number doesn't exist, proceed to OnBoarding
            navController.navigate("onBoarding") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }
    Surface(modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.nectar_primary_color) ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            val painter = painterResource(id = R.drawable.splash_full_logo)
            Image(
                painter = painter,
                contentDescription = "Splash Screen Logo"
            )
        }
//        HideNavStatusBar()
    }
}

// This is the OnBoardingScreen Composable function
@Composable
fun OnBoardingScreen(navController: NavHostController) {
    val context = LocalContext.current      // Get the current context

//    // Create a launcher for starting the activity
//    val launcher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.StartActivityForResult()
//    ){}

    Surface(
          modifier = Modifier.fillMaxSize()
      ) {
          val painter = painterResource(id = R.drawable.onboarding)
          Image(
              painter = painter,
              contentDescription = "OnBoarding Screen background picture",
              modifier = Modifier.fillMaxSize(),
              contentScale = ContentScale.Crop
          )
          Box(
              modifier = Modifier
                  .fillMaxSize(),
              contentAlignment = Alignment.BottomCenter
          ){
              Column(
                  verticalArrangement = Arrangement.Center,
                  horizontalAlignment = Alignment.CenterHorizontally,
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(bottom = 60.dp)

              ) {
                  val logoPainter = painterResource(id = R.drawable.logo)
                  Image(
                      modifier = Modifier.padding(bottom = 16.dp),
                      painter = logoPainter,
                      contentDescription = "Nectar Logo"
                  )
                  Text(
                      text = "Welcome\n to our store",
                      color = Color.White,
                      fontSize = 47.sp,
                      textAlign = TextAlign.Center,
                      fontWeight = FontWeight.SemiBold,
                      fontStyle = FontStyle.Normal,
//                      fontFamily = FontFamily(Font(R.font.gilroy_regular)),
                      lineHeight = 52.sp,
                      modifier = Modifier
                          .padding(5.dp)
                  )
                  Text(
                      text = "Get your groceries in as fast as one hour",
                      color = Color.White,
                      fontSize = 14.sp,
//                      fontFamily = FontFamily(Font(R.font.gilroy_medium)),
                      textAlign = TextAlign.Center,
                      modifier = Modifier
                          .padding(bottom = 30.dp)
                  )
                  // Get Started Button
                  NectarDesignerButton(
                      text = "Get Started",
                      onClick = {
                          navController.navigate(Screen.VerificationNavHost.route)
//                          launcher.launch(intent)
//                          (context as? Activity)?.finish()
                      }
                  )
              }
          }
      }
}

@Composable
fun HideNavStatusBar(){
    //    For removing the Status bar of Splash Screen
// System UI Controller for managing system bar colors
    val systemUiController = rememberSystemUiController()

    // Set system bars visibility (hide both navigation and status bars)
    systemUiController.isSystemBarsVisible = false

    // Optional: set system bar colors to transparent or any other color
    systemUiController.setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = false // Use light icons if the background is dark
    )
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SplashPreview() {
//    NectarComposeTheme {
//        OnBoardingScreen()
//    }
//}