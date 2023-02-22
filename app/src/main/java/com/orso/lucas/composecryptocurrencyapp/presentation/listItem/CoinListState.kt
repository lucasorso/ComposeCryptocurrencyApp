package com.orso.lucas.composecryptocurrencyapp.presentation.listItem

import com.orso.lucas.composecryptocurrencyapp.domain.model.CoinListItem

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinListItem> = emptyList(),
    val error: String = ""
)