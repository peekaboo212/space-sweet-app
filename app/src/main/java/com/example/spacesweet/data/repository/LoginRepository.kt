package com.example.spacesweet.data.repository

import com.example.spacesweet.data.model.LoginResponse
import com.example.spacesweet.data.remote.LoginService
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api:LoginService) {
    //private val api = LoginService()

    suspend fun login(email:String, password: String): Response<LoginResponse>{
        return api.login(email, password)
    }
}