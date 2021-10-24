package com.example.marketapp.domain

import com.example.marketapp.data.CompanyOverview
import com.example.marketapp.data.IncomeStatement
import com.example.marketapp.data.Stock

data class Model(val ticker: String, val stock: Stock?, val incomeStatement: IncomeStatement?, val companyOverview: CompanyOverview?)