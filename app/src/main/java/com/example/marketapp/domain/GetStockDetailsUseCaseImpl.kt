package com.example.marketapp.domain

import com.example.marketapp.data.StockRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope

class GetStockDetailsUseCaseImpl(private val stockRepository: StockRepository): GetStockDetailsUseCase {

    // coroutineScope will cancel whenever any of its children fail. So, if one network request
    // fails, all of the other requests are cancelled immediately.
    // A supervisorScope won’t cancel other children when one of them fails.
    override suspend fun execute(ticker: String): Model = supervisorScope {
        val stock = try { async { stockRepository.getStock(ticker) } } catch (e: Exception) { null }
        val incomeStatement = try { async { stockRepository.getIncomeStatement(ticker) } } catch (e: Exception) { null }
        val companyOverview = try { async { stockRepository.getCompanyOverview(ticker) } } catch (e: Exception) { null }
        return@supervisorScope Model(ticker, stock?.await(), incomeStatement?.await(), companyOverview?.await())
    }
}
