package com.dowpro.library_network.repos

import com.dowpro.library_network.*
import com.dowpro.library_network.services.MacroeconomicUSService

// X is the ISO 8601 date in display format, Y is the value
typealias Point = Pair<String, Double>

// https://www.econdb.com/api/series/IPUS/?page=1
interface MacroeconomicUSRepository {
    suspend fun getConsumerPriceIndex(): List<Point>
    suspend fun getUnemployment(): List<Point>
    suspend fun getRealGrossFixedCapitalFormation(): List<Point>
    suspend fun getRealPublicConsumption(): List<Point>
    suspend fun getRetailTrade(): List<Point>
    suspend fun getIndustrialProduction(): List<Point>
    suspend fun getRealGrossDomesticProduct(): List<Point>
    suspend fun getConsumerConfidenceIndex(): List<Point>
    suspend fun getProducerPriceIndex(): List<Point>
    suspend fun getGovernmentDebt(): List<Point>
}

data class EconDbResponse(
    val data: EconDbResponseData,
    val dataset: String,
    val description: String,
    val frequency: String,
    val geography: String,
    val ticker: String,
    val units: Any
)

data class EconDbResponseData(
    val dates: List<String>,
    val status: List<String>,
    val values: List<Double>
)

fun <A, B> Iterable<A>.product(other: Iterable<B>)
        = flatMap { a -> other.map { b -> a to b }}

fun EconDbResponse.toPoints(): List<Point> = this.data.dates.product(this.data.values)

class MacroeconomicUSRepositoryImpl(private val apiService: MacroeconomicUSService) :
    MacroeconomicUSRepository {

    override suspend fun getConsumerPriceIndex(): List<Point> = apiService.getConsumerPriceIndex().toPoints()

    override suspend fun getUnemployment(): List<Point> = apiService.getUnemployment().toPoints()

    override suspend fun getRealGrossFixedCapitalFormation(): List<Point> = apiService.getRealGrossFixedCapitalFormation().toPoints()

    override suspend fun getRealPublicConsumption(): List<Point>  = apiService.getRealPublicConsumption().toPoints()

    override suspend fun getRetailTrade(): List<Point>  = apiService.getRetailTrade().toPoints()

    override suspend fun getIndustrialProduction(): List<Point>  = apiService.getIndustrialProduction().toPoints()

    override suspend fun getRealGrossDomesticProduct(): List<Point>  = apiService.getRealGrossDomesticProduct().toPoints()

    override suspend fun getConsumerConfidenceIndex(): List<Point>  = apiService.getConsumerConfidenceIndex().toPoints()

    override suspend fun getProducerPriceIndex(): List<Point>  = apiService.getProducerPriceIndex().toPoints()

    override suspend fun getGovernmentDebt(): List<Point>  = apiService.getGovernmentDebt().toPoints()
}