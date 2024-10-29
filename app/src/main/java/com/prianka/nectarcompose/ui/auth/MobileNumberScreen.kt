package com.prianka.nectarcompose.ui.auth

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prianka.nectarcompose.ui.components.AuthTopBackground
import com.prianka.nectarcompose.ui.components.CircularArrowButton
import com.prianka.nectarcompose.ui.components.GetMobileNumberView
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme

@Composable
fun MobileNumberScreen(navController: NavController) {

    var mobileNoText by remember { mutableStateOf(TextFieldValue("+880")) }
    val ctx = LocalContext.current
    val focusManager = LocalFocusManager.current    // Initialize FocusManager for managing focus and keyboard dismissal
    val focusRequester = remember { FocusRequester() }     // Initialize FocusRequester

    // Get screen dimensions
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp


    LaunchedEffect(Unit) {
        focusRequester.requestFocus()     // Request focus when the screen opens
        mobileNoText = mobileNoText.copy(selection = TextRange(mobileNoText.text.length))     // Set cursor at end
    }

    Box(
        modifier = Modifier.fillMaxSize()
            .pointerInput(Unit) {
                
                // Clear focus when the screen is touched without showing visual effects
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {

        AuthTopBackground(navController)     //Get the Reusable TopBackground Component

        // Get the Reusable Mobile Number Component
        GetMobileNumberView(
            phoneNoText = mobileNoText,
            onTextChanged = { newText ->
                mobileNoText = newText // Update the state with the new text
            },
            focusRequester = focusRequester
        )

        Box(
            modifier = Modifier
                .padding(end = screenWidth * 0.05f, bottom = screenHeight * 0.02f)
                .align(Alignment.BottomEnd)
                .imePadding() // Automatically adjust padding when keyboard appears

        ) {
            //            Re-usable circular arrow button
            CircularArrowButton(
                onClick = {
                    // Handle the click event, e.g., navigate to another screen
                    when {
                        mobileNoText.text.isEmpty() || mobileNoText.text.length != 14 || !mobileNoText.text.startsWith("+8801")-> {

                            Toast.makeText(
                                navController.context,
                                "Please enter a valid mobile number",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        android.util.Patterns.PHONE.matcher(mobileNoText.text).matches() -> {

                            navController.navigate(Screen.OTPVerificationScreen.route)

                        }
                        else -> {
                            Toast.makeText(ctx, "Phone Number is invalid.", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MobileNumberScreenPreview() {
    NectarComposeTheme {
        MobileNumberScreen(navController = rememberNavController())
    }
}