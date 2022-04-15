package com.storesoko.rickmortyapp.Network.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.storesoko.rickmortyapp.Network.models.Character
import com.storesoko.rickmortyapp.R
import kotlinx.android.synthetic.main.rv_item.view.*

class MainAdapter (val charactersList: List<Character>):RecyclerView.Adapter<MainAdapter.MainViewHolder>(){
    class MainViewHolder(private val itemView:View):RecyclerView.ViewHolder(itemView) {
       fun bindData(character:Character){
           val name = itemView.name
           val image = itemView.image

           name.text = character.name
           val url = character.image
           Glide.with(image)
               .load(url)
               .circleCrop()
               .into(image)
       }

    }

//for method 2

//    private var items = ArrayList<Character>()
//    fun setListData(data: ArrayList<Character>){
//        this.items = data
//    }
//
//    class MainViewHolder(private val itemView:View):RecyclerView.ViewHolder(itemView) {
//       private var name = itemView.name
//        private var image = itemView.image
//
//        fun bind(data:Character){
//            name.text = data.name
//
//            val url = data.image
//            Glide.with(image)
//                .load(url)
//                .into(image)
//        }
//    }

    //end method 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent, false)
        return MainViewHolder(inflater)
    }
    //for method2
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData(charactersList[position])
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
    //end method 2

    //for method1

//    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//       holder.bind(items[position])
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
}