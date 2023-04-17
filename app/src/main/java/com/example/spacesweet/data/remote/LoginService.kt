package com.example.spacesweet.data.remote

import android.util.Log
import com.example.spacesweet.data.model.LoginRequest
import com.example.spacesweet.data.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class LoginService @Inject constructor(private val loginDataSource: LoginDataSource) {
    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun login(email: String, password:String): Response<LoginResponse> {
        return withContext(Dispatchers.IO){
            val request = LoginRequest(email, password)
            loginDataSource.login(request)
        }
    }
}