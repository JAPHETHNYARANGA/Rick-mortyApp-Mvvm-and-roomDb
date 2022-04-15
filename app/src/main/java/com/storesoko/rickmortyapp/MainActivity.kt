package com.storesoko.rickmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.storesoko.rickmortyapp.Network.Adapter.MainAdapter
import com.storesoko.rickmortyapp.Network.ViewModel.mainViewModel
import com.storesoko.rickmortyapp.Network.dataState.ScreenState
import com.storesoko.rickmortyapp.Network.models.Character
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val viewModel: mainViewModel by lazy{
        ViewModelProvider(this).get(mainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Todo the function commented below is only placed there when we are not using Screenstate

//       viewModel.characterLiveData.observe(this,{characters->
//           val adapter = MainAdapter(characters)
//           val recyclerView = findViewById<RecyclerView>(R.id.charactersRv)
//
//           recyclerView?.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
//           recyclerView?.adapter = adapter
//       })

        //Todo observe the live data if you are using screen state
        viewModel.characterLiveData.observe(this,{ state ->
            processCharactersResponse(state)

        })
    }

    //Todo this method is added if we are using ScreenState
    private fun processCharactersResponse(state : ScreenState<List<Character>?>){

        when(state){
            is ScreenState.Loading ->{
                //TODO ADD PROGRESSBAR
                progressBar.visibility = View.VISIBLE
            }
            is ScreenState.Success ->{
                //TODO load adapter
                progressBar.visibility = View.GONE
                    if(state.data != null){
                        val adapter = MainAdapter(state.data)
                        val recyclerView = findViewById<RecyclerView>(R.id.charactersRv)

                        recyclerView?.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                        recyclerView?.adapter = adapter
                    }


            }
            is ScreenState.Error ->{
                progressBar.visibility = View.GONE
                val view = progressBar.rootView
                Snackbar.make(view,state.message!!, Snackbar.LENGTH_LONG).show()

            }
        }
    }
}