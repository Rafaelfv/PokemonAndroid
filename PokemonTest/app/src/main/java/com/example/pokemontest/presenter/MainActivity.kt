package com.example.pokemontest.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.pokemontest.R
import com.example.pokemontest.databinding.ActivityMainBinding
import com.example.pokemontest.presenter.ui.fragments.FragmentListPokemon
import com.example.pokemontest.utils.Planet

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        if (savedInstanceState == null) {
            setFragment(FragmentListPokemon())
        }

        val a = Planet.Marte
        val b = Planet.Basic(2)
        val c = Planet.PlanetWithSatellites(2, listOf("sa1","sa2"))



    }

    private fun getPlanet (planet: Planet) {
        when(planet){
            is Planet.Marte -> {}
            is Planet.Basic -> {}
            is Planet.PlanetWithSatellites -> {}
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_main, fragment, fragment.javaClass.name)
            .addToBackStack(fragment.javaClass.name)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
    }

}