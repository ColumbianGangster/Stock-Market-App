package com.dowpro.feature_stock_details.domain

import com.dowpro.library_network.IncomeStatement


interface IncomeStatementMapper {
    fun map(incomeStatement: IncomeStatement?): IncomeStatement?
}

