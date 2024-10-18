package com.prianka.nectarcompose.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.auth.VerificationActivity
import com.prianka.nectarcompose.ui.components.NectarDesignerButton
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        // This line allows your app to draw behind system bars
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            NectarComposeTheme {
                SplashNavigation()
            }
        }
    }
}

//this is the SplashNavigation Composable function that sets up the navigation graph for the splash screen
@Composable
fun SplashNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash"){
        composable("splash"){
            SplashScreen(navController)
        }
        composable("onBoarding"){
            OnBoardingScreen()
        }
    }
}

// SplashScreen Composable function that displays the splash screen
@Composable
fun SplashScreen(navController: NavController){

    // Start a coroutine for the splash delay
    LaunchedEffect(key1 = true) {
        // Delay for 2 seconds
        kotlinx.coroutines.delay(3000)
        // Navigate to the main screen
        navController.navigate("onBoarding") {
            popUpTo("splash") { inclusive = true }
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
fun OnBoardingScreen() {
    val context = LocalContext.current // Get the current context

    // Create a launcher for starting the activity
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ){}

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
                      lineHeight = 52.sp,
                      modifier = Modifier
                          .padding(5.dp)
                  )
                  Text(
                      text = "Ger your groceries in as fast as one hour",
                      color = Color.White,
                      fontSize = 14.sp,
                      textAlign = TextAlign.Center,
                      modifier = Modifier
                          .padding(bottom = 30.dp)
                  )
                  // Get Started Button
                  NectarDesignerButton(
                      text = "Get Started",
                      onClick = {
                          val intent = Intent(context, VerificationActivity::class.java)
                          launcher.launch(intent)
                          (context as? Activity)?.finish()
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashPreview() {
    NectarComposeTheme {
        OnBoardingScreen()
    }
}