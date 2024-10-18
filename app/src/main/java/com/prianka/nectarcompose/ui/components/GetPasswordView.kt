package com.prianka.nectarcompose.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prianka.nectarcompose.R

@Composable
fun GetPasswordView(
    passwordText: TextFieldValue, // Accept the text as a parameter
    onTextChanged: (TextFieldValue) -> Unit,
){
    val focusManager = LocalFocusManager.current  // Request for inputText Focusing and Hiding as well as keyboard manager
    var passwordVisible by remember { mutableStateOf(false) }

    BasicTextField(
        value = passwordText, // Use the passed text value
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        onValueChange = { newPasswordText ->
            if (newPasswordText.text.length <= 20) {
                onTextChanged(newPasswordText) // Only update the text if it's within the limit
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.Black,
            fontSize = 16.sp
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    innerTextField() // This renders the actual text input field
                }

                IconButton(
                    onClick = { passwordVisible = !passwordVisible }
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (passwordVisible) R.drawable.visibilityon else R.drawable.visibilityoff
                        ),
                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                        Modifier.size(20.dp),
                        tint = Color.Gray
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done // Specify "Done" action
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()

            }
        )

    )
}