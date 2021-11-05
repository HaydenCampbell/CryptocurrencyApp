package com.haydencampbell.cryptocurrencyapp.presentation.coin_detail

import com.haydencampbell.cryptocurrencyapp.domain.model.Coin
import com.haydencampbell.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)

