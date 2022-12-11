package com.dowpro.marketapp.di

import com.dowpro.library_network.repos.StockRepository
import com.dowpro.feature_stock_details.domain.GetStockDetailsUseCase
import com.dowpro.feature_stock_details.domain.GetStockDetailsUseCaseImpl
import com.dowpro.feature_stock_details.domain.IncomeStatementMapper
import com.dowpro.feature_stock_details.domain.IncomeStatementMapperImpl
import com.dowpro.library_network.storage.StorageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideIncomeStatementMapper(): IncomeStatementMapper =
        IncomeStatementMapperImpl()

    @Provides
    fun provideGetStockDetailsUseCase(
        stockRepository: StockRepository,
        storageRepository: StorageRepository,
        incomeStatementMapper: IncomeStatementMapper
    ): GetStockDetailsUseCase =
        GetStockDetailsUseCaseImpl(
            stockRepository,
            storageRepository,
            incomeStatementMapper
        )
}