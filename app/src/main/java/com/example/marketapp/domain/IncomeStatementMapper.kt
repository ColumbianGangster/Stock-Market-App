package com.example.marketapp.domain

import com.example.marketapp.data.IncomeStatement


interface IncomeStatementMapper {
    fun map(incomeStatement: IncomeStatement?): IncomeStatement?
}

