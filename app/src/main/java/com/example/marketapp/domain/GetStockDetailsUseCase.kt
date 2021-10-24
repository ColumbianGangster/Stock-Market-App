package com.example.marketapp.domain

interface GetStockDetailsUseCase {
    suspend fun execute(ticker: String): DomainStockDetails
}
