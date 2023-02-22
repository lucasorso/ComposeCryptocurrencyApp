package com.orso.lucas.composecryptocurrencyapp.presentation.detail

import com.orso.lucas.composecryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = "",
)