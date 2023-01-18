package com.dowpro.library_network.services

import com.dowpro.library_network.repos.EconDbResponse
import retrofit2.http.GET

// TODO: Move the base url out of the class
interface MacroeconomicUSService {
    @GET("https://www.econdb.com/api/series/CPIUS/?format=json")
    suspend fun getConsumerPriceIndex(): EconDbResponse

    @GET("https://www.econdb.com/api/series/URATEUS/?format=json")
    suspend fun getUnemployment(): EconDbResponse

    @GET("https://www.econdb.com/api/series/RGFCFUS/?format=json")
    suspend fun getRealGrossFixedCapitalFormation(): EconDbResponse

    @GET("https://www.econdb.com/api/series/RPUCUS/?format=json")
    suspend fun getRealPublicConsumption(): EconDbResponse

    @GET("https://www.econdb.com/api/series/RETAUS/?format=json")
    suspend fun getRetailTrade(): EconDbResponse

    @GET("https://www.econdb.com/api/series/IPUS/?format=json")
    suspend fun getIndustrialProduction(): EconDbResponse

    @GET("https://www.econdb.com/api/series/RGDPUS/?format=json")
    suspend fun getRealGrossDomesticProduct(): EconDbResponse

    @GET("https://www.econdb.com/api/series/CONFUS/?format=json")
    suspend fun getConsumerConfidenceIndex(): EconDbResponse

    @GET("https://www.econdb.com/api/series/PPIUS/?format=json")
    suspend fun getProducerPriceIndex(): EconDbResponse

    @GET("https://www.econdb.com/api/series/GDEBTUS/?format=json")
    suspend fun getGovernmentDebt(): EconDbResponse
}