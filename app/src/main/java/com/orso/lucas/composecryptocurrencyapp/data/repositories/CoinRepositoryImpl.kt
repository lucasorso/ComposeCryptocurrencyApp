package com.orso.lucas.composecryptocurrencyapp.data.repositories

import com.orso.lucas.composecryptocurrencyapp.data.remote.CoinService
import com.orso.lucas.composecryptocurrencyapp.domain.model.CoinDetail
import com.orso.lucas.composecryptocurrencyapp.domain.model.CoinListItem
import com.orso.lucas.composecryptocurrencyapp.domain.repositories.CoinRepository
import retrofit2.HttpException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val service: CoinService,
) : CoinRepository {

    override suspend fun getCoins(): Result<List<CoinListItem>> {
        return try {
            val coins = service.getCoins().map(CoinListItem::fromResponse)
            Result.success(coins)
        } catch (e: HttpException) {
            Result.failure(e)
        } catch (e: HttpException) {
            Result.failure(e)
        }
    }

    override suspend fun getCoinById(id: String): Result<CoinDetail> {
        return try {
            val detailsResponse = service.getCoinById(id)
            val detail = CoinDetail.fromResponse(detailsResponse)
            Result.success(detail)
        } catch (e: HttpException) {
            Result.failure(e)
        } catch (e: HttpException) {
            Result.failure(e)
        }
    }
}