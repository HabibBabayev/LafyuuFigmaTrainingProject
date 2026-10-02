package com.example.lafyufigmatraining2.repository

import com.example.lafyufigmatraining2.ApiService.ApiService
import com.example.lafyufigmatraining2.general.Resource
import com.example.lafyufigmatraining2.model.LoginRequestModel
import com.example.lafyufigmatraining2.model.LoginResponseModel
import com.example.lafyufigmatraining2.model.Product
import com.example.lafyufigmatraining2.model.ProductResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AppRepository @Inject constructor(
val apiService: ApiService
) {
    fun getLogin(password: String,userName: String): Flow<Resource<LoginResponseModel>> =flow{
        emit(Resource.Loading)
        try {
            val response= apiService.loginUser(user = LoginRequestModel(password=password, username = userName))
            if (response.isSuccessful){

                response.body()?.let {
                    emit(Resource.Success(it))

                }?:emit(Resource.Error(response.message())
                )
            }else emit(Resource.Error(response.message()))

        } catch (e: Exception){
            emit(Resource.Error(e.message.toString()))
        }

    }.flowOn(Dispatchers.IO)
    fun getProducts(): Flow<Resource<ProductResponseModel>> =flow{
        emit(Resource.Loading)
        try{
            val response=apiService.getProducts()
            if (response.isSuccessful){
                response.body()?.let { product->
                    emit(Resource.Success(product))
                }?:emit(Resource.Error(response.message()))
            } else emit(Resource.Error(response.message()))

        } catch (e: Exception){
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}