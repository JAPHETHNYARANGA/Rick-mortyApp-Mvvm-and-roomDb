package com.storesoko.rickmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.storesoko.rickmortyapp.Network.Retrofit.ApiClient
import com.storesoko.rickmortyapp.Network.models.CharacterResponse
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = ApiClient.apiService.fetchCharacters("1")
        client.enqueue(object : retrofit2.Callback<CharacterResponse>{
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if(response.isSuccessful){
                    Log.i("response1", "Successful response"+response.body())
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("failed",""+t.message)
            }
        })
    }
}