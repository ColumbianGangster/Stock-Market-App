package com.example.marketapp.di

import com.example.marketapp.data.StockRepository
import com.example.marketapp.data.StorageRepository
import com.example.marketapp.domain.GetStockDetailsUseCase
import com.example.marketapp.domain.GetStockDetailsUseCaseImpl
import com.example.marketapp.domain.IncomeStatementMapper
import com.example.marketapp.domain.IncomeStatementMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideIncomeStatementMapper(): IncomeStatementMapper = IncomeStatementMapperImpl()

    @Provides
    fun provideGetStockDetailsUseCase(
        stockRepository: StockRepository,
        storageRepository: StorageRepository,
        incomeStatementMapper: IncomeStatementMapper
    ): GetStockDetailsUseCase =
        GetStockDetailsUseCaseImpl(stockRepository, storageRepository, incomeStatementMapper)


}