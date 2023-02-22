package com.orso.lucas.composecryptocurrencyapp.domain.model

import com.orso.lucas.composecryptocurrencyapp.data.remote.detail.CoinDetailResponse

data class CoinDetail(
    val coinId: String,
    val name: String,
    val descriptino: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val teamMembers: List<TeamMember>,
) {
    companion object {
        fun fromResponse(response: CoinDetailResponse) = CoinDetail(
            coinId = response.id,
            name = response.name,
            descriptino = response.description,
            symbol = response.symbol,
            rank = response.rank,
            isActive = response.isActive,
            tags = response.tags.map { it.name },
            teamMembers = response.teamMembers.map { TeamMember(it.name, it.position) }
        )
    }
}

data class TeamMember(
    val name: String,
    val positionName: String,
)