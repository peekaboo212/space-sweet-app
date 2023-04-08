package com.example.spacesweet.data.remote

import com.example.spacesweet.data.model.LoginResponse
import com.example.spacesweet.data.model.LoginRequest
import kotlinx.coroutines.Deferred
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginDataSource {
    //@POST("v3/a0699711-d1e0-40c2-8de6-a0df2fec905b")
    //fun login(@Body("user") user: String, @Body("password") password: String): Response<LoginResponse>

    //@POST("/api/login")
    //fun Login(@Body params: RequestBody): Deferred<LoginResponse>

        @POST("/jayson")
        fun postJson(@Body body: LoginRequest): LoginResponse

}
