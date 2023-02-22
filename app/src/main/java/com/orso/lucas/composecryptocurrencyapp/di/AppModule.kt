package com.orso.lucas.composecryptocurrencyapp.di

import com.orso.lucas.composecryptocurrencyapp.common.Constants
import com.orso.lucas.composecryptocurrencyapp.data.remote.CoinService
import com.orso.lucas.composecryptocurrencyapp.data.repositories.CoinRepositoryImpl
import com.orso.lucas.composecryptocurrencyapp.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinService(): CoinService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(CoinService::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(service: CoinService): CoinRepository = CoinRepositoryImpl(service)

}