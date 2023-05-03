package com.example.retrofit_compose.network

import com.example.retrofit_compose.model.Data
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getData(): List<Data>

    companion object{
        private var apiService: ApiService?= null

        fun getInstance(): ApiService{
            if(apiService==null){
                apiService = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}

//https://jsonplaceholder.typicode.com/posts