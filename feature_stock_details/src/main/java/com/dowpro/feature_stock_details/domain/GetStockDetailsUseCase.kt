package com.dowpro.feature_stock_details.domain

interface GetStockDetailsUseCase {
    suspend fun execute(ticker: String): DomainStockDetails
}
