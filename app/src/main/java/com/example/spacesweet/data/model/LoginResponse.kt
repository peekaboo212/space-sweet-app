package com.example.spacesweet.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,

    @SerializedName("username")
    @Expose
    var username: String? = null,

    @SerializedName("email")
    @Expose
    var email: String? = null
)