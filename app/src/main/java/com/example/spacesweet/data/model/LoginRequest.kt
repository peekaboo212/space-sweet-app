package com.example.spacesweet.data.model

class LoginRequest {
    var email: String? = null
    var password: String? = null

    fun LoginRequest(email: String?, password: String?) {
        this.email = email
        this.password = password
    }
}