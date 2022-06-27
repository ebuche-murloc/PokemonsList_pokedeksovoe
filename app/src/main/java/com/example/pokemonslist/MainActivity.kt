package com.example.pokemonslist

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.content.LocalBroadcastManager
import android.view.MenuItem
import com.example.pokemonslist.Common.Common
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //create broadcast handle
    private val showDetail = object: BroadcastReceiver(){
        override fun onReceive(p0: Context?, intent: Intent?) {
            if(intent!!.action!!.toString() == Common.KEY_ENABLE_HOME){
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                supportActionBar!!.setDisplayShowHomeEnabled(true)

                //replace fraggment
                val detailFragment = PokemonDetail.getInstance()
                val position = intent.getIntExtra("position", -1)
                val bundle = Bundle()
                bundle.putInt("position", position)
                detailFragment.arguments = bundle

                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.list_pokemon_fragment, detailFragment)
                fragmentTransaction.addToBackStack("detail")
                fragmentTransaction.commit()

                //set pokemon name for Toolbar
                val pokemon = Common.pokemonList[position]
                toolbar.title = pokemon.name

            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.setTitle("POKEMON LIST")
        setSupportActionBar(toolbar)

        //register broadcast
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(showDetail, IntentFilter(Common.KEY_ENABLE_HOME))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            android.R.id.home -> {
                toolbar.title = "POKEMON LIST"

                //clear all fragment in stack with name 'detail'
                supportFragmentManager.popBackStack("detail", FragmentManager.POP_BACK_STACK_INCLUSIVE)

                supportActionBar!!.setDisplayShowHomeEnabled(false)
                supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            }
        }
        return true
    }
}