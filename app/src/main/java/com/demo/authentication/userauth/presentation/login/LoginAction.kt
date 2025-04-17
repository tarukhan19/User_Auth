package com.demo.authentication.userauth.presentation.login

import android.content.Context

data class LoginAction(
    // UI Actions
    val onEmailChange: (String) -> Unit = {},
    val onPasswordChange: (String) -> Unit = {},
    val onTogglePasswordVisibility: () -> Unit = {},
    val onSubmit: () -> Unit = {},
    val onGoogleLogin: () -> Unit = {},
    val onSignUpNavigate: () -> Unit = {},
    val isButtonEnabled: Boolean = false
)
