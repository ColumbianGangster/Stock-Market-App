package com.example.marketapp.di

import com.example.marketapp.data.StockRepository
import com.example.marketapp.data.StorageRepository
import com.example.marketapp.domain.GetStockDetailsUseCase
import com.example.marketapp.domain.GetStockDetailsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetStockDetailsUseCase(stockRepository: StockRepository, storageRepository: StorageRepository): GetStockDetailsUseCase =
        GetStockDetailsUseCaseImpl(stockRepository, storageRepository)


}