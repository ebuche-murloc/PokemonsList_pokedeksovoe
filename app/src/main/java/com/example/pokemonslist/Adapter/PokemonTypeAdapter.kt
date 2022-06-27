package com.example.pokemonslist.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonslist.Common.Common
import com.example.pokemonslist.Interface.IItemClickListener
import com.example.pokemonslist.R
import com.robertlevonyan.views.chip.Chip

class PokemonTypeAdapter (internal var context: Context, internal var typeList:List<String>):
RecyclerView.Adapter<PokemonTypeAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.chip_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.chip.text = typeList[position]
        holder.chip.setBackgroundColor(Common.getColorByType(typeList[position]))
    }

    override fun getItemCount(): Int {
        return typeList.size
    }



    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        internal var chip: Chip


        init{
            chip = itemView.findViewById(R.id.chip) as Chip
            chip.setOnClickListener{ Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show() }
        }
    }


}