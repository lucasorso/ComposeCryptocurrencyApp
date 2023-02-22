package com.orso.lucas.composecryptocurrencyapp.data.remote.listItem

import com.squareup.moshi.Json

data class CoinListItemResponse(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "symbol")
    val symbol: String,
    @Json(name = "is_new")
    val isNew: Boolean,
    @Json(name = "is_active")
    val isActive: Boolean,
    @Json(name = "rank")
    val rank: Int,
)