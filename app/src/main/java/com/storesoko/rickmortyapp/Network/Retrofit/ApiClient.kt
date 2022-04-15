package com.storesoko.rickmortyapp.Network.Retrofit

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {

    val BASE_URL = "https://rickandmortyapi.com/api/"


//    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
//
//    private val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .build()
//    }

    private val retrofit:Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService : ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

}
