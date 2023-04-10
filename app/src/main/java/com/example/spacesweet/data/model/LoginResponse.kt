package com.example.spacesweet.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("status")
    @Expose
    var Status: Boolean = false
)