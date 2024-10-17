package com.example.pokemontest.injection

import android.app.Application
import androidx.room.Room
import com.example.pokemontest.data.db.AppDatabase
import com.example.pokemontest.data.db.PokemonDao
import com.example.pokemontest.data.repository.PokemonLocalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(applicationContext: Application) {

    var dataBase: AppDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "my_database"
    ).allowMainThreadQueries().build()

    @Provides
    @Singleton
    internal fun provideRoomDatabase() = dataBase

    @Provides
    @Singleton
    internal fun providePokemonDao() = dataBase.pokemonDao()


    @Provides
    @Singleton
    internal fun providePokemonDataSource(pokemonDao: PokemonDao) = PokemonLocalDataSource(pokemonDao)

}