package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prianka.nectarcompose.R

@Composable
fun GetMobileNumberView(
    text: TextFieldValue, // Accept the text as a parameter
    onTextChanged: (TextFieldValue) -> Unit,
    maxLength: Int = 14
) {
    val focusRequester = remember { FocusRequester() }

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
                text = "Enter your mobile number",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding( bottom = 20.dp),
                textAlign = TextAlign.Start
            )

            Text(
                text = "Mobile Number",
                fontSize = 14.sp,
                color = colorResource(id = R.color.nectar_gray_text_color)
            )

            // Phone number input
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.flag), // replace with your flag icon
                    contentDescription = "Bangladesh Flag",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // BasicTextField for mobile input
                BasicTextField(
                    value = text, // Use the passed text value
                    maxLines = 1,
                    minLines = 1,
                    onValueChange = { newText ->
                        if (newText.text.length <= maxLength) {
                            onTextChanged(newText) // Only update the text if it's within the limit
                        }
                                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    textStyle = TextStyle(color = Color.Black),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Search // Specify "Done" action
                    ),

                    keyboardActions = KeyboardActions(onDone = {
                        focusRequester.freeFocus() // Optionally clear focus

                    })

                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            HorizontalDividerComponent()

        }
    }
}

