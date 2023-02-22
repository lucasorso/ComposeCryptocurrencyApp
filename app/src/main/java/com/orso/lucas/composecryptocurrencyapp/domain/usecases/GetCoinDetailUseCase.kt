package com.orso.lucas.composecryptocurrencyapp.domain.usecases

import com.orso.lucas.composecryptocurrencyapp.common.StateHolder
import com.orso.lucas.composecryptocurrencyapp.domain.model.CoinDetail
import com.orso.lucas.composecryptocurrencyapp.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository,
) {

    operator fun invoke(id: String): Flow<StateHolder<CoinDetail>> = flow<StateHolder<CoinDetail>> {
        repository.getCoinById(id)
            .onSuccess { detail ->
                emit(StateHolder.Success(detail))
            }
            .onFailure { th ->
                emit(StateHolder.Error(th))
            }
    }.onStart {
        emit(StateHolder.Loading())
    }
}