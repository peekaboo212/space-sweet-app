package com.example.spacesweet.data.repository

import com.example.spacesweet.data.remote.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api:LoginService) {
    //private val api = LoginService()

    suspend fun login(user:String, password: String): String{
        return api.login(user, password)
    }
}