package com.example.pokemonslist.Interface

import android.view.View

interface IItemClickListener {
    fun onClick (view: View, position: Int)
}