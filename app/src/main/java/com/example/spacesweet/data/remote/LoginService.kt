package com.example.spacesweet.data.remote

import android.util.Log
import com.example.spacesweet.data.model.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(private val loginDataSource: LoginDataSource) {
    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun login(email: String, password:String): Boolean{
        return withContext(Dispatchers.IO){
            val request = LoginRequest(email, password)
            val response = loginDataSource.login(request)
            Log.i("status","${response.body()?.Status}")
            response.body()?.Status ?: false
        }
    }
}