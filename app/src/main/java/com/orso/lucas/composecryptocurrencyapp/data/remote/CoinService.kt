package com.orso.lucas.composecryptocurrencyapp.data.remote

import com.orso.lucas.composecryptocurrencyapp.data.remote.detail.CoinDetailResponse
import com.orso.lucas.composecryptocurrencyapp.data.remote.listItem.CoinListItemResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinListItemResponse>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") id: String): CoinDetailResponse
}