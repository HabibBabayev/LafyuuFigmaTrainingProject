package com.example.lafyufigmatraining2.ApiService

import com.example.lafyufigmatraining2.model.LoginRequestModel
import com.example.lafyufigmatraining2.model.LoginResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun loginUser(
        @Body user: LoginRequestModel
    ): Response<LoginResponseModel>


}