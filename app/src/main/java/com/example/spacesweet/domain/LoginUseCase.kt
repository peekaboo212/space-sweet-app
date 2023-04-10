package com.example.spacesweet.domain

import com.example.spacesweet.data.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
    //private val respository = LoginRepository()

    suspend operator fun invoke(email: String, password: String): Boolean{
        return repository.login(email, password)==true
    }
}