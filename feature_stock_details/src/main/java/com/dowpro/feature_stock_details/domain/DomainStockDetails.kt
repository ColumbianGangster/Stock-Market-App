package com.dowpro.feature_stock_details.domain

import com.dowpro.library_network.CompanyOverview
import com.dowpro.library_network.IncomeStatement
import com.dowpro.library_network.Stock

data class DomainStockDetails(
    val ticker: String,
    val stock: Stock?,
    val incomeStatement: IncomeStatement?,
    val companyOverview: CompanyOverview?
)