package com.demo.userauth.presentation.login

import com.demo.userauth.utils.Resource

data class LoginState (
    val emailId : String = "",
    val password : String = "",

    val emailIdError : Boolean = false,
    val passwordError : Boolean = false,

    val showPassword : Boolean = false,

    val isLoading : Boolean = false,
    val loginResult : Resource<String>? = null
)