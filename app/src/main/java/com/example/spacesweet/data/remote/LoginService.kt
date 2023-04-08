package com.example.spacesweet.data.remote

import com.example.sapcesweet.data.remote.LoginDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(private val loginDataSource: LoginDataSource) {
    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun login(user: String, password:String): String{
        return withContext(Dispatchers.IO){
            val response = loginDataSource.login(user, password)
            response.body()?.Estatus ?: "declined"
        }
    }
}