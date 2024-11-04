package com.prianka.nectarcompose.ui.auth

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prianka.nectarcompose.datastore.DatastoreManager
import com.prianka.nectarcompose.ui.components.AuthTopBackground
import com.prianka.nectarcompose.ui.components.CircularArrowButton
import com.prianka.nectarcompose.ui.components.GetMobileNumberView
import kotlinx.coroutines.launch

@Composable
fun MobileNumberScreen(navController: NavController) {
    val keyboardController = LocalSoftwareKeyboardController.current

    var mobileNoText by remember { mutableStateOf(TextFieldValue()) }
    val coroutineScope = rememberCoroutineScope()   // For Saving data in data store instead of lifecycleScope
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current    // Initialize FocusManager for managing focus and keyboard dismissal
    val focusRequester = remember { FocusRequester() }     // Initialize FocusRequester

    // Get screen dimensions
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp


    LaunchedEffect(Unit) {
        focusRequester.requestFocus()     // Request focus when the screen opens
//        mobileNoText = mobileNoText.copy(selection = TextRange(mobileNoText.text.length))     // Set cursor at end
    }

    Box(
        modifier = Modifier.fillMaxSize()
            .pointerInput(Unit) {
                
                detectTapGestures(onTap = {      // Clear focus when the screen is touched without showing visual effects
                    focusManager.clearFocus()
                }
                )
            }
    ) {

        AuthTopBackground(navController, keyboardController)     //Get the Reusable TopBackground Component

        // Get the Reusable Mobile Number Component
        GetMobileNumberView(
            phoneNoText = mobileNoText,
            onTextChanged = { newText ->
                mobileNoText = newText
            },
            focusRequester = focusRequester
        )

        Box(
            modifier = Modifier
                .padding(end = screenWidth * 0.05f, bottom = screenHeight * 0.055f)
                .align(Alignment.BottomEnd)
                .imePadding() // Automatically adjust padding when keyboard appears

        ) {
            //  Re-usable circular arrow button
            CircularArrowButton(
                onClick = {
                    // Handle the click event, e.g., navigate to another screen
                    when {
                        mobileNoText.text.isEmpty() -> {
                            Toast.makeText(
                                navController.context,
                                "Mobile number cannot be empty",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        mobileNoText.text.length != 10 -> {
                            Toast.makeText(
                                   navController.context,
                                "Mobile number must be 10 digits",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        !mobileNoText.text.startsWith("1") -> {
                            Toast.makeText(
                                navController.context,
                                "Mobile number must start with '1'",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        android.util.Patterns.PHONE.matcher(mobileNoText.text).matches() -> {

                            Log.d("MobileNo", mobileNoText.text)
                            coroutineScope.launch {
                                saveCredentials("+880" + mobileNoText.text, context)
                            }

                            keyboardController?.hide()  // Hide the keyboard
                            navController.navigate(Screen.OTPVerificationScreen.route)
                        }
                        else -> {            // Handles NUll safety
                            Toast.makeText(
                                navController.context,
                                "Phone Number is invalid.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            )
        }
    }
}

// Save function with DatastoreManager
suspend fun saveCredentials(userMobileNo: String, ctx: Context) {
    val datastoreManager = DatastoreManager(ctx)
    datastoreManager.saveString("user_mobile", userMobileNo)
}

//
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun MobileNumberScreenPreview() {
//    NectarComposeTheme {
//        MobileNumberScreen(navController = rememberNavController())
//    }
//}