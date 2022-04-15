package com.storesoko.rickmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.storesoko.rickmortyapp.Network.Adapter.MainAdapter
import com.storesoko.rickmortyapp.Network.ViewModel.mainViewModel



class MainActivity : AppCompatActivity() {

    private val viewModel: mainViewModel by lazy{
        ViewModelProvider(this).get(mainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       viewModel.characterLiveData.observe(this,{characters->
           val adapter = MainAdapter(characters)
           val recyclerView = findViewById<RecyclerView>(R.id.charactersRv)

           recyclerView?.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
           recyclerView?.adapter = adapter
       })
    }
}