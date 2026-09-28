package com.example.lafyufigmatraining2.di

import com.example.lafyufigmatraining2.ApiService.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getLoginAccess(): Retrofit{
        val BASE_URL="https://dummyjson.com/"
        val retrofit= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
        return retrofit
    }

    @Provides
    @Singleton
    fun getApiService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }

}