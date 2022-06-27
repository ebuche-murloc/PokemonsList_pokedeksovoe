package com.example.pokemonslist.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pokemonslist.Model.Pokemon
import com.example.pokemonslist.PokemonList
import com.example.pokemonslist.R

class PokemonListAdapter(internal var context: Context,
                          internal var pokemonList:List<Pokemon>):RecyclerView.Adapter<PokemonListAdapter.MyViewHolder> () {

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        internal var img_pokemon:ImageView
        internal var txt_pokemon:TextView
        init{
            img_pokemon = itemView.findViewById(R.id.pokemon_image) as ImageView
            txt_pokemon = itemView.findViewById(R.id.pokemon_name) as TextView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.pokemon_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(pokemonList[position].img).into(holder.img_pokemon)
        holder.txt_pokemon.text = pokemonList[position].name
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}