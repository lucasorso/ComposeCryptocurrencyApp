package com.orso.lucas.composecryptocurrencyapp.domain.repositories

import com.orso.lucas.composecryptocurrencyapp.domain.model.CoinDetail
import com.orso.lucas.composecryptocurrencyapp.domain.model.CoinListItem

interface CoinRepository {

    suspend fun getCoins(): Result<List<CoinListItem>>

    suspend fun getCoinById(id: String): Result<CoinDetail>
}