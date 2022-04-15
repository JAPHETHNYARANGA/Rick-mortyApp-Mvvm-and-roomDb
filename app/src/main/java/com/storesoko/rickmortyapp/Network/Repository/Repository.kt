package com.storesoko.rickmortyapp.Network.Repository

import com.storesoko.rickmortyapp.Network.Retrofit.ApiInterface
//the repository is the single source of truth(ssot), that helps connect data from our api with our room db to a single view model
//add lifecycle dependency 1>for view model 2>for live data

class Repository (private val apiService:ApiInterface ){
    fun getCharacters(page:String) = apiService.fetchCharacters(page)

}