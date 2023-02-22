package com.orso.lucas.composecryptocurrencyapp.domain.usecases

import com.orso.lucas.composecryptocurrencyapp.common.StateHolder
import com.orso.lucas.composecryptocurrencyapp.domain.model.CoinListItem
import com.orso.lucas.composecryptocurrencyapp.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository,
) {

    operator fun invoke(): Flow<StateHolder<List<CoinListItem>>> = flow<StateHolder<List<CoinListItem>>> {
        repository.getCoins()
            .onSuccess { coins ->
                emit(StateHolder.Success(coins))
            }
            .onFailure { th ->
                emit(StateHolder.Error(th))
            }
    }.onStart {
        emit(StateHolder.Loading())
    }
}