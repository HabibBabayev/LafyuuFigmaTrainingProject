package com.example.lafyufigmatraining2.model


import com.google.gson.annotations.SerializedName

data class LoginRequestModel(
    @SerializedName("password")
    val password: String?,
    @SerializedName("username")
    val username: String?
)