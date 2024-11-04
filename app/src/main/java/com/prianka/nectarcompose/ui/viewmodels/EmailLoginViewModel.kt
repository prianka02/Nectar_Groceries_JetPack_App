package com.prianka.nectarcompose.ui.viewmodels

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmailLoginViewModel @Inject constructor() : ViewModel() {
    private val _userEmailText = MutableStateFlow(TextFieldValue(""))
    val userEmailText: StateFlow<TextFieldValue> = _userEmailText

    private val _userPasswordText = MutableStateFlow(TextFieldValue(""))
    val userPasswordText: StateFlow<TextFieldValue> = _userPasswordText

    fun onEmailChange(newEmail: TextFieldValue) {
        _userEmailText.value = newEmail
    }

    fun onPasswordChange(newPassword: TextFieldValue) {
        _userPasswordText.value = newPassword
    }

    // Login function with basic validation
    fun login(onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            val email = _userEmailText.value.text
            val password = _userPasswordText.value.text

            when {
                email.isEmpty() ->  {
                    onError("Please enter an Email")
                }
                password.isEmpty() -> {
                    onError("Please enter a Password")
                }
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    onError("Email is invalid.")
                }
                password.length < 8 -> {
                    onError("Password is too short, must be at least 8 characters.")
                }
                else -> {
                    onSuccess()
                }
            }
        }
    }}