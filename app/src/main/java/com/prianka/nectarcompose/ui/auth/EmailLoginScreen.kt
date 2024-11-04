package com.prianka.nectarcompose.ui.auth

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.components.GetEmailView
import com.prianka.nectarcompose.ui.components.GetPasswordView
import com.prianka.nectarcompose.ui.components.HorizontalDividerComponent
import com.prianka.nectarcompose.ui.home.HomeActivity

@Composable
fun EmailLoginScreen(navController: NavHostController){
    val context = LocalContext.current
    val activity = (context as? Activity)   // This casts the context to an Activity

    val focusManager = LocalFocusManager.current    // Initialize FocusManager for managing focus and keyboard dismissal


    var userEmailText by remember { mutableStateOf(TextFieldValue("")) } // Manage the text state
    var userPasswordText by remember { mutableStateOf(TextFieldValue("")) } // Manage the text state

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {

                // Clear focus when the screen is touched without showing visual effects
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
            .imePadding()  // Adjusts for keyboard opening

    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.authbackgroundtop),
            contentScale = ContentScale.Crop,
            contentDescription = "Top Bar Image",
            modifier = Modifier.fillMaxWidth()
        )
        Image(
            painter = painterResource(id = R.drawable.bottomblurbackground),
            contentScale = ContentScale.Crop,
            contentDescription = "Bottom Background Image",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 5.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())  // Make Column scrollable
                .padding(start = 24.dp, end = 24.dp, top = 120.dp)
                .align(Alignment.Center)
        ) {
            Text(
                text = "Loging",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 15.dp),
                textAlign = TextAlign.Start
            )

            Text(
                text = "Enter your emails and password",
                fontSize = 14.sp,
                color = colorResource(id = R.color.nectar_gray_text_color)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Email",
                fontSize = 14.sp,
                color = colorResource(id = R.color.nectar_gray_text_color)
            )
            Spacer(modifier = Modifier.height(15.dp))
            GetEmailView(
                emailText = userEmailText, // Pass the current text to TopBackgroundImageSet
                onTextChanged = { newText ->
                    userEmailText = newText // Update the state with the new text

                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDividerComponent()
            Spacer(modifier = Modifier.height(30.dp))


            Text(
                text = "Password",
                fontSize = 14.sp,
                color = colorResource(id = R.color.nectar_gray_text_color)
            )
            GetPasswordView(
                passwordText = userPasswordText, // Pass the current text to TopBackgroundImageSet
                onTextChanged = { newText ->
                    userPasswordText = newText // Update the state with the new text

                }
            )
            HorizontalDividerComponent()

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 15.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Forgot Password?",
                        fontSize = 13.sp,
                    )
                }

                Button(
                    onClick = {
                        when {
                            userEmailText.text.isEmpty() && userPasswordText.text.isEmpty() -> {
                                Toast.makeText(
                                    context,
                                    "Please enter a valid email and password",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            !android.util.Patterns.EMAIL_ADDRESS.matcher(userEmailText.text).matches() -> {
                                Toast.makeText(context, "Email is invalid.", Toast.LENGTH_SHORT).show()
                            }
                            userPasswordText.text.length < 8 -> {
                                Toast.makeText(context, "Password is too short, Must be 8 characters", Toast.LENGTH_SHORT).show()
                            }
                            else -> {
                                val intent = Intent(context, HomeActivity::class.java)
                                context.startActivity(intent)
                                activity?.finish()
                            }
                        }

                        Log.d("password", userPasswordText.toString())
                        Log.d("email", userEmailText.toString())

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF53B175)
                    ),
                    shape = RoundedCornerShape(19.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(65.dp)
                ) {
                    Text(text = "Login", color = Color.White, fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    Text(
                        text = "Don’t have an account? ",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.padding(bottom = 30.dp),
                    )
                    Text(
                        text = "Signup",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.nectar_primary_color),
                        modifier = Modifier.clickable{
                            navController.navigate(Screen.SignUpScreen.route)
                        }
                    )
                }
            }
        }
    }
}