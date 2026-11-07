package com.example.lafyufigmatraining2.ApiService

import com.example.lafyufigmatraining2.model.LoginRequestModel
import com.example.lafyufigmatraining2.model.LoginResponseModel
import com.example.lafyufigmatraining2.model.Product
import com.example.lafyufigmatraining2.model.ProductResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST("auth/login")
    suspend fun loginUser(
        @Body user: LoginRequestModel
    ): Response<LoginResponseModel>
    @GET("products")
    suspend fun getProducts(): Response<ProductResponseModel>
    @GET("products/category/{category}")
    suspend fun getItemByCategory(
        @Path("category")category: String
    ): Response<ProductResponseModel>
    @GET("products/{id}")
    suspend fun getSingleProduct(
        @Path("id")id: Int
    ): Response<Product>
    @GET("products/search")
    suspend fun  getSearchedProduct(
        @Query("q")query: String
    ): Response<ProductResponseModel>
}