package com.example.marketapp.domain

import com.example.marketapp.data.*
import com.google.gson.Gson
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope

class GetStockDetailsUseCaseImpl(
    private val stockRepository: StockRepository,
    private val storageRepository: StorageRepository,
    private val incomeStatementMapper: IncomeStatementMapper
) : GetStockDetailsUseCase {

    override suspend fun execute(ticker: String): DomainStockDetails = supervisorScope {
        val cachedStock = storageRepository.read(ticker + StorageRepository.STOCK_FILENAME)
        val cachedIncomeStatement =
            storageRepository.read(ticker + StorageRepository.INCOME_STATEMENT_FILENAME)
        val cachedCompanyOverview =
            storageRepository.read(ticker + StorageRepository.COMPANY_OVERVIEW_FILENAME)

        val stock = try {
            async { stockRepository.getStock(ticker) }
        } catch (e: Exception) {
            null
        }
        val incomeStatement = try {
            async { stockRepository.getIncomeStatement(ticker) }
        } catch (e: Exception) {
            null
        }
        val companyOverview = try {
            async { stockRepository.getCompanyOverview(ticker) }
        } catch (e: Exception) {
            null
        }

        return@supervisorScope DomainStockDetails(
            ticker = ticker,
            stock = cachedStock.useCacheOrApi(
                deferred = stock,
                fileName = ticker + StorageRepository.STOCK_FILENAME,
                mapper = { it }
            ),
            incomeStatement = cachedIncomeStatement.useCacheOrApi(
                deferred = incomeStatement,
                fileName = ticker + StorageRepository.INCOME_STATEMENT_FILENAME,
                mapper = { incomeStatementMapper.map(it) }
            ),
            companyOverview = cachedCompanyOverview.useCacheOrApi(
                deferred = companyOverview,
                fileName = ticker + StorageRepository.COMPANY_OVERVIEW_FILENAME,
                mapper = { it }
            ),
        )
    }

    private suspend inline fun <reified T> String?.useCacheOrApi(deferred: Deferred<T>?, fileName: String, mapper: (T?) -> T?): T? =
        if (isNullOrEmpty()) {
            mapper.invoke(deferred?.await())
                .also {
                    storageRepository.write(
                        Gson().toJson(it),
                        fileName
                    )
                }
        } else Gson().fromJson(this, T::class.java)
}
