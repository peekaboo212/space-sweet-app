package com.example.spacesweet.data.remote

import com.example.spacesweet.data.model.LoginResponse
import com.example.spacesweet.data.model.LoginRequest
import kotlinx.coroutines.Deferred
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginDataSource {
    @POST("/api/v1/auth")
    suspend fun login(@Body request:LoginRequest): Response<LoginResponse>

}
