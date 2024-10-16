package com.example.pokemontest.injection

import com.example.pokemontest.presenter.viewmodels.FragmentDetailViewModel
import com.example.pokemontest.presenter.viewmodels.FragmentListViewModel
import com.example.pokemontest.presenter.viewmodels.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RoomModule::class])
interface ComponentInjector {
    fun inject(viewModelFragmentList: FragmentListViewModel)
    fun inject(viewModelDetail: FragmentDetailViewModel)
    fun inject(mainActivityViewModel: MainActivityViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ComponentInjector
        fun networkModule(networkModule: NetworkModule): Builder
        fun roomModule(roomModule: RoomModule): Builder
    }
}