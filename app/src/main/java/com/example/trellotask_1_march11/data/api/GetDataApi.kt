package com.example.trellotask_1_march11.data.api

import com.example.trellotask_1_march11.models.ReceivedDataItem
import retrofit2.http.GET

interface GetDataApi {
    @GET("metrics/overall_latency")
    suspend fun getData() : ReceivedDataItem
}