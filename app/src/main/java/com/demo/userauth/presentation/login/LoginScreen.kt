package com.demo.userauth.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.userauth.R
import com.demo.userauth.presentation.components.CustomButton
import com.demo.userauth.presentation.components.CustomImage
import com.demo.userauth.presentation.components.CustomTextFieldForm
import com.demo.userauth.presentation.components.CustomTextForm
import com.demo.userauth.presentation.components.ScaffoldUi
import com.demo.userauth.presentation.theme.primaryColor
import com.demo.userauth.presentation.login.LoginIntent.EnterEmail
import com.demo.userauth.presentation.login.LoginIntent.EnterPassword

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    onSignUpNavigate: () -> Unit,
) {
    val loginState = loginViewModel._loginState

    ScaffoldUi(showToolBar = false) {
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        )
        {
            CustomImage(
                imageInt = R.drawable.app_icon,
                contentDescription = R.string.app_icon,
                modifier = Modifier
                    .size(width = 150.dp, height = 150.dp)
                    .padding(10.dp)
            )
        }
        Spacer(modifier = Modifier.padding(top = 40.dp))
        CustomTextFieldForm(
            value = loginState.emailId,
            onValueChange = { loginViewModel.handleIntent(EnterEmail(it)) },
            label = R.string.email_id,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 5.dp),
            singleLine = true,
            isError = loginState.emailIdError,
            keyboardType = KeyboardType.Email,
            placeholder = R.string.email_id_placeholder,
            leadingIcon = Icons.Filled.Email,
            contentDescription = R.string.email_id_placeholder,
        )

        CustomTextFieldForm(
            value = loginState.password,
            onValueChange = { loginViewModel.handleIntent(EnterPassword(it)) },
            label = R.string.password,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 5.dp),
            singleLine = true,
            isError = loginState.passwordError,
            keyboardType = KeyboardType.Password,
            placeholder = R.string.password_placeholder,
            leadingIcon = Icons.Filled.Lock,
            trailingIcon = if (loginViewModel.showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
            contentDescription = R.string.password_placeholder,
            leadingContentDescription = if (loginViewModel.showPassword) R.string.show_password else R.string.hide_password,
            onTrailingIconClicked = { loginViewModel.showPassword = !loginViewModel.showPassword },
            visualTransformation = if (loginViewModel.showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
        )

        CustomButton(
            isButtonEnabled = !loginState.passwordError && !loginState.emailIdError && loginState.emailId.isNotEmpty() && loginState.password.isNotEmpty(),
            onClick = { loginViewModel.handleIntent(LoginIntent.Submit) },
            icon = Icons.Filled.CheckCircleOutline,
            buttonContent = stringResource(R.string.sign_in)
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            CustomTextForm(text = R.string.dont_have_acc)
            CustomTextForm(
                text = R.string.sign_up,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable { onSignUpNavigate() },
                fontSize = 16.sp,
                color = primaryColor,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
