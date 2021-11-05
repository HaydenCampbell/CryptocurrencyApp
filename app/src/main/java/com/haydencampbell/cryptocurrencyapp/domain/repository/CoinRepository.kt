package com.haydencampbell.cryptocurrencyapp.domain.repository

import com.haydencampbell.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.haydencampbell.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}