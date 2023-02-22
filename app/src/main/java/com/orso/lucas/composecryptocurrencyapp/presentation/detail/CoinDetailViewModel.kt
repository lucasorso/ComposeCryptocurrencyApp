package com.orso.lucas.composecryptocurrencyapp.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orso.lucas.composecryptocurrencyapp.common.Constants
import com.orso.lucas.composecryptocurrencyapp.common.StateHolder
import com.orso.lucas.composecryptocurrencyapp.domain.usecases.GetCoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let(::getCoin)
    }

    private fun getCoin(id: String) = getCoinDetailUseCase(id).onEach { result ->
        when (result) {
            is StateHolder.Error -> _state.value = CoinDetailState(error = result.th.localizedMessage ?: "An unexpected error occured")
            is StateHolder.Loading -> _state.value = CoinDetailState(isLoading = true)
            is StateHolder.Success -> _state.value = CoinDetailState(coinDetail = result.data)
        }
    }.launchIn(viewModelScope)
}