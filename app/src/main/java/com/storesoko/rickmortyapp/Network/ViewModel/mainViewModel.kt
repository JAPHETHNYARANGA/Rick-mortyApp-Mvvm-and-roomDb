package com.storesoko.rickmortyapp.Network.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.storesoko.rickmortyapp.Network.Repository.Repository
import com.storesoko.rickmortyapp.Network.Retrofit.ApiClient
import com.storesoko.rickmortyapp.Network.dataState.ScreenState
import com.storesoko.rickmortyapp.Network.models.Character
import com.storesoko.rickmortyapp.Network.models.CharacterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class mainViewModel(private val repository: Repository = Repository(ApiClient.apiService)) : ViewModel(){

//   private var charactersLiveData = MutableLiveData<List<Character>>()

   //use this with screen state, otherwise use the  commented one above
   private var charactersLiveData = MutableLiveData<ScreenState<List<Character>?>>()


//    val characterLiveData:LiveData<List<Character>>

    //use this with screen state, otherwise use the  commented one above
    val characterLiveData:LiveData<ScreenState<List<Character>?>>

    get() = charactersLiveData

    init {
        fetchCharacter()
    }

    private fun fetchCharacter(){
        val client = repository.getCharacters("1")

        //add this line if you are using screen state
        charactersLiveData.postValue(ScreenState.Loading(null))

        client.enqueue(object : Callback<CharacterResponse>{
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if(response.isSuccessful){
                    Log.d("datat", "success")
                   // charactersLiveData.postValue(response.body()?.results)

                    //use this with screen state, otherwise use the  commented one above
                    charactersLiveData.postValue(ScreenState.Success(response.body()?.results))
                }
                //add this line if you are using Screen state
                else{
                    charactersLiveData.postValue(ScreenState.Error(response.code().toString(), null))
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
//                Log.d("failute", ""+t.message.toString())
                charactersLiveData.postValue(ScreenState.Error(t.message.toString(), null))
            }
        })
    }
}