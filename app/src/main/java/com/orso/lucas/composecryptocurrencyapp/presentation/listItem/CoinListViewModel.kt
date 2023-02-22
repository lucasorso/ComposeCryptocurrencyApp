package com.orso.lucas.composecryptocurrencyapp.presentation.listItem

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orso.lucas.composecryptocurrencyapp.common.StateHolder
import com.orso.lucas.composecryptocurrencyapp.domain.usecases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() = getCoinsUseCase().onEach { result ->
        when (result) {
            is StateHolder.Error -> _state.value = CoinListState(error = result.th.localizedMessage ?: "An unexpected error occured")
            is StateHolder.Loading -> _state.value = CoinListState(isLoading = true)
            is StateHolder.Success -> _state.value = CoinListState(coins = result.data)
        }
    }.launchIn(viewModelScope)
}