package com.prianka.nectarcompose.ui.auth

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    // a variable for a context
    val ctx = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        var mobileNoText by remember { mutableStateOf(TextFieldValue("+880")) } // Manage the text state

//Get the Reusable TopBackground Component
        AuthTopBackground()

        Spacer(modifier = Modifier.height(30.dp))

// Get the Reusable Mobile Number Component
        GetMobileNumberView(
            phoneNoText = mobileNoText, // Pass the current text to TopBackgroundImageSet
            onTextChanged = { newText ->
                mobileNoText = newText // Update the state with the new text

            }
        )

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
                    // Handle the click event, e.g., navigate to another screen
                    when {
                        mobileNoText.text.isEmpty() || mobileNoText.text.length != 14 -> {

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


//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun MobileNumberScreenPreview() {
//    NectarComposeTheme {
//        MobileNumberScreen(navController = rememberNavController())
//    }
//}