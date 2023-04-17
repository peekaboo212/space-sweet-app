package com.example.spacesweet.domain

import com.example.spacesweet.data.model.LoginResponse
import com.example.spacesweet.data.repository.LoginRepository
import retrofit2.Response
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
    //private val respository = LoginRepository()

    suspend operator fun invoke(email: String, password: String): Response<LoginResponse> {
        return repository.login(email, password)
    }
}