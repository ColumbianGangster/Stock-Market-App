package com.example.marketapp.data

interface StorageRepository {
    fun write(content: String, fileName: String)
    fun read(fileName: String): String?


    companion object {
        val STOCK_FILENAME = "_stock.json"
        val COMPANY_OVERVIEW_FILENAME = "_company_overview.json"
        val INCOME_STATEMENT_FILENAME = "_income_statement.json"
    }
}