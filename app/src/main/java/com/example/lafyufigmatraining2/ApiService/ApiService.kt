package com.example.lafyufigmatraining2.ApiService

import com.example.lafyufigmatraining2.model.LoginRequestModel
import com.example.lafyufigmatraining2.model.LoginResponseModel
import com.example.lafyufigmatraining2.model.Product
import com.example.lafyufigmatraining2.model.ProductResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun loginUser(
        @Body user: LoginRequestModel
    ): Response<LoginResponseModel>
    @GET("products")
    suspend fun getProducts(): Response<ProductResponseModel>
}