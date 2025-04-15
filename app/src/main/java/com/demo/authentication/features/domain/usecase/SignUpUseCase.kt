package com.demo.authentication.features.domain.usecase

import com.demo.authentication.core.domain.utils.AppResult
import com.demo.authentication.core.domain.utils.NetworkError
import com.demo.authentication.features.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String, name : String, mobileNo : String): AppResult<FirebaseUser, NetworkError> {
        return repository.signUp(email, password, name, mobileNo)
    }
}