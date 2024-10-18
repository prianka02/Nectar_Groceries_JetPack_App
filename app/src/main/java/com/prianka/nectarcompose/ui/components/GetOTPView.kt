package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.prianka.nectarcompose.R
import com.prianka.nectarcompose.ui.auth.MobileNumberScreen
import com.prianka.nectarcompose.ui.theme.NectarComposeTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalFocusManager


@Composable
fun GetOTPView(){

    var otpCode by remember { mutableStateOf("") }

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current  // Request for inputText Focusing and Hiding as well as keyboard manager

    // Automatically request focus when the screen loads
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.3f)
            .padding(start = 20.dp, end = 20.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = "Enter your 4-digit code",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding( bottom = 20.dp),
                textAlign = TextAlign.Start
            )

            Text(
                text = "Code",
                fontSize = 14.sp,
                color = colorResource(id = R.color.nectar_gray_text_color)
            )

//          OTP View Text Field
            BasicTextField(
                value = otpCode,
                maxLines = 1,
                onValueChange = {
                    if(it.length <= 4){
                        otpCode = it
                    }
                },
                modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),

                keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Done // Specify "Done" action
                    ),

                keyboardActions = KeyboardActions(onDone = {
                        focusManager.clearFocus() // Optionally clear focus
                    })

            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    repeat(4){ index ->
                        val number = when{
                            index >= otpCode.length -> ""
                            else -> otpCode[index]
                        }

                        Column(
                            verticalArrangement = Arrangement.spacedBy(6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = number.toString(),
                                fontSize = 15.sp,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Box(
                                modifier = Modifier
                                    .width(8.dp)
                                    .height(2.dp)
                                    .background(colorResource(id = R.color.OTP_field_underscore_color))
                            )

                        }
                    }

                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            HorizontalDividerComponent()
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GetOTPViewPreview() {
//    NectarComposeTheme {
//        GetOTPView()
//    }
//}