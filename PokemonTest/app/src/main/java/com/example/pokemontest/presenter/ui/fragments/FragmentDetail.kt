package com.example.pokemontest.presenter.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.pokemontest.data.ResponsePokemonDetails
import com.example.pokemontest.databinding.FragmentPokemonDetailBinding
import com.example.pokemontest.utils.Constants.Companion.KEY_POKEMON_DETAIL
import com.example.pokemontest.utils.Constants.Companion.KEY_POKEMON_DETAIL_ID

class FragmentDetail : Fragment() {

    private lateinit var binding: FragmentPokemonDetailBinding
    private var pokemonDetails: ResponsePokemonDetails? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokemonDetails = arguments?.getParcelable(KEY_POKEMON_DETAIL_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (pokemonDetails != null) {
            /*pokemonDetails.apply {
                Glide.with(requireContext()).load(this?.sprites?.frontDefault)
                    .into(binding.imageView)
                binding.name.text = this?.name
                binding.weight.text = this?.weight.toString()
                binding.height.text = this?.height.toString()
                binding.type.text = this?.types?.first()?.type?.name
            }

             */
        }
    }

}
