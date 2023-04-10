package com.example.spacesweet.data.repository

import com.example.spacesweet.data.remote.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api:LoginService) {
    //private val api = LoginService()

    suspend fun login(email:String, password: String): Boolean{
        return api.login(email, password)
    }
}