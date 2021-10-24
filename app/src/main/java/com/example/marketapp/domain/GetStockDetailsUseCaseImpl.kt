package com.example.marketapp.domain

import com.example.marketapp.data.*
import com.google.gson.Gson
import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope

class GetStockDetailsUseCaseImpl(private val stockRepository: StockRepository,
                                 private val storageRepository: StorageRepository): GetStockDetailsUseCase {

    // coroutineScope will cancel whenever any of its children fail. So, if one network request
    // fails, all of the other requests are cancelled immediately.
    // A supervisorScope won’t cancel other children when one of them fails.
    override suspend fun execute(ticker: String): DomainStockDetails = supervisorScope {
        val cachedStock = storageRepository.read(ticker+StorageRepository.STOCK_FILENAME)
        val cachedIncomeStatement = storageRepository.read(ticker+StorageRepository.INCOME_STATEMENT_FILENAME)
        val cachedCompanyOverview = storageRepository.read(ticker+StorageRepository.COMPANY_OVERVIEW_FILENAME)

        val stock = try { async { stockRepository.getStock(ticker) } } catch (e: Exception) { null }
        val incomeStatement = try { async { stockRepository.getIncomeStatement(ticker) } } catch (e: Exception) { null }
        val companyOverview = try { async { stockRepository.getCompanyOverview(ticker) } } catch (e: Exception) { null }

        return@supervisorScope DomainStockDetails(
            ticker = ticker,
            stock = if (cachedStock.isNullOrEmpty()) {
                stock?.await()
                    .also { storageRepository.write(Gson().toJson(it), ticker+StorageRepository.STOCK_FILENAME) }
            }
            else Gson().fromJson(cachedStock, Stock::class.java),

            incomeStatement = if (cachedIncomeStatement.isNullOrEmpty()) {
                incomeStatement?.await()
                    .also { storageRepository.write(Gson().toJson(it), ticker+StorageRepository.INCOME_STATEMENT_FILENAME) }
            }
            else Gson().fromJson(cachedIncomeStatement, IncomeStatement::class.java),

            companyOverview = if (cachedCompanyOverview.isNullOrEmpty()) {
                companyOverview?.await()
                    .also { storageRepository.write(Gson().toJson(it), ticker+StorageRepository.COMPANY_OVERVIEW_FILENAME) }
            }
            else Gson().fromJson(cachedCompanyOverview, CompanyOverview::class.java),
        )
    }
}
