package com.prianka.nectarcompose.ui.auth

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.components.GetPasswordView
import com.prianka.nectarcompose.ui.components.HorizontalDividerComponent
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme

@Composable
fun SignUpScreen(navController: NavHostController){
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current    // Initialize FocusManager for managing focus and keyboard dismissal

//    UserInputs Managements
    var userNameText by remember { mutableStateOf(TextFieldValue("")) }
    var userEmailText by remember { mutableStateOf(TextFieldValue("")) }
    var userPasswordText by remember { mutableStateOf(TextFieldValue("")) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {

                // Clear focus when the screen is touched without showing visual effects
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
            .imePadding()
    ) {
        // Top Background image
        Image(
            painter = painterResource(id = R.drawable.authbackgroundtop),
            contentScale = ContentScale.Crop,
            contentDescription = "Top Bar Image",
            modifier = Modifier.fillMaxWidth()
        )
//        Bottom Background Image
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
                .verticalScroll(rememberScrollState())
                .padding(start = 24.dp, end = 24.dp, top = 220.dp)
                .align(Alignment.Center)
        ) {
            Text(
                text = "Sign Up",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 15.dp),
                textAlign = TextAlign.Start
            )

            Text(
                text = "Enter your credentials to continue",
                fontSize = 14.sp,
                color = colorResource(id = R.color.nectar_gray_text_color)
            )

            Spacer(modifier = Modifier.height(20.dp))

//          Get UserName component
            Text(
                text = "Username",
                fontSize = 14.sp,
                color = colorResource(id = R.color.nectar_gray_text_color)
            )
            Spacer(modifier = Modifier.height(15.dp))

            //  Composable function for getting Username view
            GetUserView(
                userText = userNameText,
                onTextChanged = { newText ->
                    userNameText = newText
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDividerComponent()
            Spacer(modifier = Modifier.height(30.dp))

//          Get Email Component
            Text(
                text = "Email",
                fontSize = 14.sp,
                color = colorResource(id = R.color.nectar_gray_text_color)
            )
            Spacer(modifier = Modifier.height(15.dp))

            //  Composable function for getting Email view
            GetSignUpEmailView(
                emailText = userEmailText,
                onTextChanged = { newText ->
                    userEmailText = newText

                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDividerComponent()
            Spacer(modifier = Modifier.height(30.dp))

//          Get Password Component
            Text(
                text = "Password",
                fontSize = 14.sp,
                color = colorResource(id = R.color.nectar_gray_text_color)
            )

            //  Composable function for getting Password view
            GetPasswordView(
                passwordText = userPasswordText,
                onTextChanged = { newText ->
                    userPasswordText = newText

                }
            )
            HorizontalDividerComponent()

//          Bottom View As a Column
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(10.dp))

//                Annotated string
                TermsAndPolicyText(
                    onTermsClicked = {
                        // Handle Terms of Service click
                     Log.d("Terms", "Terms of Service clicked")
                                     },
                    onPrivacyClicked = {
                            // Handle Privacy Policy click
                     Log.d("Privacy", "Privacy Policy clicked")
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        when {
                            userNameText.text.isEmpty() && userEmailText.text.isEmpty() && userPasswordText.text.isEmpty() -> {
                                Toast.makeText(
                                    context,
                                    "Please enter a valid user name, email and password",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            !android.util.Patterns.EMAIL_ADDRESS.matcher(userEmailText.text).matches() -> {
                                Toast.makeText(context, "Email is invalid.", Toast.LENGTH_SHORT).show()
                            }
                            userPasswordText.text.length < 8 -> {
                                Toast.makeText(context, "User Password is too short", Toast.LENGTH_SHORT).show()
                            }
                            else -> {
                                navController.navigate(Screen.LocationScreen.route)
                            }
                        }

                        Log.d("password", userPasswordText.toString())

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF53B175)
                    ),
                    shape = RoundedCornerShape(19.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(65.dp)
                ) {
                    Text(text = "Sign Up", color = Color.White, fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    Text(
                        text = "Already have an account? ",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
//                      modifier = Modifier.padding(bottom = 30.dp),
                    )
                    Text(
                        text = "Login",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.nectar_primary_color),
                        modifier = Modifier.clickable{
                            navController.navigate(Screen.EmailLoginScreen.route)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun GetUserView(
    userText: TextFieldValue, // Accept the text as a parameter
    onTextChanged: (TextFieldValue) -> Unit,
){
    val focusManager = LocalFocusManager.current  // Request for inputText Focusing and Hiding as well as keyboard manager

    BasicTextField(
        value = userText, // Use the passed text value
        singleLine = true,
        onValueChange = { newUserText ->
            if (newUserText.text.length <= 30) {
                onTextChanged(newUserText) // Only update the text if it's within the limit
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.Black),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.Words,
            imeAction = ImeAction.Next // Specify "Done" action
        ),
        keyboardActions = KeyboardActions(
//            onDone = {
//                focusManager.clearFocus()
//            },
            onNext = {focusManager.moveFocus(FocusDirection.Down) }
        )
    )
}

@Composable
fun GetSignUpEmailView(
    emailText: TextFieldValue, // Accept the text as a parameter
    onTextChanged: (TextFieldValue) -> Unit,
) {
    val focusManager = LocalFocusManager.current  // Request for inputText Focusing and Hiding as well as keyboard manager

    BasicTextField(
        value = emailText, // Use the passed text value
        singleLine = true,
        onValueChange = { newEmailText ->
            if (newEmailText.text.length <= 25) {
                onTextChanged(newEmailText) // Only update the text if it's within the limit
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.Black),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    innerTextField() // This renders the actual text input field
                }

                // Only show the verified icon if the email is valid
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailText.text).matches()) {
                    Icon(
                        painter = painterResource(id = R.drawable.verified_email), // Verified email icon
                        contentDescription = "Email Verified",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified // Ensure the icon retains its original color
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next // Specify "Done" action
        ),
        keyboardActions = KeyboardActions(
            onNext = {focusManager.moveFocus(FocusDirection.Down) }
//            onDone = {
//            focusManager.clearFocus() }
        )
    )
}

@Composable
fun TermsAndPolicyText(onTermsClicked: () -> Unit, onPrivacyClicked: () -> Unit) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = colorResource(id = R.color.nectar_gray_text_color))) {
            append("By continuing you agree to our ")
        }

        // Annotate the "Terms of Service" text
        pushStringAnnotation(tag = "TERMS", annotation = "Terms of Service")
        withStyle(style = SpanStyle(color = colorResource(id = R.color.nectar_primary_color))) {
            append("Terms of Service")
        }
        pop()

        withStyle(style = SpanStyle(color = colorResource(id = R.color.nectar_gray_text_color))) {
            append(" and ")
        }

        // Annotate the "Privacy Policy" text
        pushStringAnnotation(tag = "PRIVACY", annotation = "Privacy Policy")
        withStyle(style = SpanStyle(color = colorResource(id = R.color.nectar_primary_color))) {
            append("Privacy Policy")
        }
        pop()
        withStyle(style = SpanStyle(color = colorResource(id = R.color.nectar_gray_text_color))) {
            append(".")
        }
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = "TERMS", start = offset, end = offset)
                .firstOrNull()?.let {
                    onTermsClicked()
                }
            annotatedString.getStringAnnotations(tag = "PRIVACY", start = offset, end = offset)
                .firstOrNull()?.let {
                    onPrivacyClicked()
                }
        },
        modifier = Modifier.padding(8.dp)
    )
}



//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SignUpScreenPreview() {
//    NectarComposeTheme {
//        SignUpScreen(navController = rememberNavController())
//    }
//}