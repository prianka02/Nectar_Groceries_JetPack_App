package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun GetEmailView(
    emailText: TextFieldValue, // Accept the text as a parameter
    onTextChanged: (TextFieldValue) -> Unit,
){
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
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next // Specify "Done" action
        ),

        keyboardActions = KeyboardActions(
            onNext = {focusManager.moveFocus(FocusDirection.Down) }

//            onDone = {
//                focusManager.clearFocus()
//            }
        )

    )
}