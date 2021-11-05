package com.haydencampbell.cryptocurrencyapp.presentation.coin_list

import com.haydencampbell.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)

