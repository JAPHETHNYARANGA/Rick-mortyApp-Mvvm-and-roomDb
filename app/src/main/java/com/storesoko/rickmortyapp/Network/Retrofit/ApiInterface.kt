package com.storesoko.rickmortyapp.Network.Retrofit

import com.storesoko.rickmortyapp.Network.models.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("character")
    fun fetchCharacters(@Query("page") page:String):Call<CharacterResponse>
}