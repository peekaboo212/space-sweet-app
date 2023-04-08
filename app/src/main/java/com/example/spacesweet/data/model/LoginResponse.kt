package com.example.spacesweet.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("status")
    var Estatus: Boolean = false
)