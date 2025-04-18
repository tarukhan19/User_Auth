package com.demo.authentication.core.presentation.utils

import android.util.Patterns

/*
Returns true if:
The email is empty (emailId.isEmpty()).
The email format is incorrect (!Patterns.EMAIL_ADDRESS.matcher(emailId).matches()).
Returns false if the email is valid.
*/

/*
Returns true if:
The password has 6 or fewer characters (invalid password).
Returns false if the password is strong enough.
 */

fun String.isValidEmail(): Boolean = isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidPassword(): Boolean = length < 6

fun String.isValidName(): Boolean = isEmpty() || length < 4

fun String.isValidPhoneNumber(): Boolean = isEmpty() || length <= 9

fun String.matchesPassword(confirmPassword: String): Boolean =
    !this.isValidPassword() && !confirmPassword.isValidPassword() && this != confirmPassword
