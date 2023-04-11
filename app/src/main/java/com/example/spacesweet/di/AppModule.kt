package com.example.spacesweet.di

import com.example.spacesweet.data.remote.LoginDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Injeccion con providers de librerias o interfaces
@Module //Le indicas que en un modulo de DI
@InstallIn(SingletonComponent::class) //Es el escope de hilt
class AppModule {

    @Singleton // crea una unica instancia de la clase
    @Provides // Prepara la clase para ser injectado
    fun provideReftrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.179:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideLoginDateSource(retrofit: Retrofit): LoginDataSource{
        return retrofit.create(LoginDataSource::class.java)
    }
}