package com.example.pokemontest.presenter.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pokemontest.R
import com.example.pokemontest.databinding.FragmentListPokemonBinding
import com.example.pokemontest.presenter.ui.adapters.AdapterListPokemon
import com.example.pokemontest.presenter.viewmodels.FragmentListViewModel
import com.example.pokemontest.utils.Constants.Companion.KEY_POKEMON_DETAIL
import javax.inject.Inject

class FragmentListPokemon : Fragment() {

    private val offset = 25
    private var counter = 1
    private lateinit var binding: FragmentListPokemonBinding

    @Inject
    lateinit var viewModel: FragmentListViewModel
    private lateinit var adapter: AdapterListPokemon


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentListViewModel::class.java]
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
        getListPokemon(offset*counter)
        binding.recyclerView.adapter = adapter

        adapter.onBottomReached = {
            counter++
            getListPokemon(offset*counter)
        }
        setupObservers()
    }

    private fun getListPokemon(currentOffset: Int) {
        viewModel.getListPokemon(currentOffset)
        binding.progressCircular.visibility = View.VISIBLE
    }

    private fun setupObservers() {
        viewModel.currentList.observe(viewLifecycleOwner) { pokemonList ->
            binding.progressCircular.visibility = View.GONE
            adapter.updateList(pokemonList)
            adapter.onItemClick = { pokemon ->
                val bundle = Bundle()
                bundle.putParcelable(KEY_POKEMON_DETAIL, pokemon.details)
                val fragment = FragmentDetail()
                fragment.arguments = bundle
                goToDetailsFragment(fragment)
            }
        }
    }

    private fun goToDetailsFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.add(R.id.container_main_fragment, fragment, fragment.javaClass.name)
            .addToBackStack(fragment.javaClass.name)
            .commit()
    }
}