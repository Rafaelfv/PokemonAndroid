package com.example.pokemontest.presenter.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pokemontest.R
import com.example.pokemontest.databinding.FragmentListPokemonBinding
import com.example.pokemontest.presenter.ui.adapters.AdapterListPokemon
import com.example.pokemontest.presenter.viewmodels.FragmentListViewModel
import com.example.pokemontest.utils.Constants.Companion.KEY_POKEMON_DETAIL
import com.example.pokemontest.utils.Constants.Companion.KEY_POKEMON_DETAIL_ID
import kotlinx.coroutines.launch

class FragmentListPokemon : Fragment() {

    private val offset = 25
    private var counter = 1
    private lateinit var binding: FragmentListPokemonBinding


    private val viewModel: FragmentListViewModel by viewModels()
    private lateinit var adapter: AdapterListPokemon


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListPokemonBinding.inflate(inflater, container, false)
        adapter = AdapterListPokemon()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getListPokemon(offset * counter)
        binding.recyclerView.adapter = adapter

        adapter.onBottomReached = {
            counter++
            getListPokemon(offset * counter)
        }
        setupObservers()
    }

    private fun getListPokemon(currentOffset: Int) {
        viewModel.getListPokemon(currentOffset)
        binding.progressCircular.visibility = View.VISIBLE
    }

    private fun setupObservers() {

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->

                    binding.progressCircular.visibility = if (state.loading) View.VISIBLE else View.GONE
                    adapter.updateList(state.pokemonServiceList)
                    adapter.notifyDataSetChanged()
                    adapter.onItemClick = { pokemon ->
                        val bundle = Bundle()
                        bundle.putInt(KEY_POKEMON_DETAIL_ID, pokemon.id)
                        val fragment = FragmentDetail()
                        fragment.arguments = bundle
                        goToDetailsFragment(fragment)
                    }
                }
            }
        }

        /**
         * Para los state flows cambia en la forma de observar las variables
         *

        viewModel.currentList.observe(viewLifecycleOwner) { pokemonList ->
        binding.progressCircular.visibility = View.GONE
        adapter.updateList(pokemonList)
        adapter.notifyDataSetChanged()

        adapter.onItemClick = { pokemon ->
        val bundle = Bundle()
        bundle.putParcelable(KEY_POKEMON_DETAIL, pokemon.details)
        val fragment = FragmentDetail()
        fragment.arguments = bundle
        goToDetailsFragment(fragment)
        }
         */

    }

    private fun goToDetailsFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.add(R.id.container_main_fragment, fragment, fragment.javaClass.name)
            .addToBackStack(fragment.javaClass.name)
            .commit()
    }
}