package com.example.pokemontest.injection

import com.example.pokemontest.presenter.viewmodels.FragmentDetailViewModel
import com.example.pokemontest.presenter.viewmodels.FragmentListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ComponentInjector {
    fun inject(viewModelFragmentList: FragmentListViewModel)
    fun inject(viewModelDetail: FragmentDetailViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ComponentInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}