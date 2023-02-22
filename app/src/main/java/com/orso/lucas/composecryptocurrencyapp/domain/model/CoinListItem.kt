package com.orso.lucas.composecryptocurrencyapp.domain.model

import com.orso.lucas.composecryptocurrencyapp.data.remote.listItem.CoinListItemResponse

data class CoinListItem(
    val id: String,
    val name: String,
    val symbol: String,
    val isActive: Boolean,
    val rank: Int,
) {

    companion object {

        fun fromResponse(response: CoinListItemResponse) = CoinListItem(
            id = response.id,
            name = response.name,
            symbol = response.symbol,
            isActive = response.isActive,
            rank = response.rank
        )
    }
}
