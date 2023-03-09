package com.example.trellotask_1_march11.models

data class ReceivedDataItem(
    val end_date: String,
    val overall_censorship_latency: Double,
    val overall_censorship_latency_without_lido_censorship: Double,
    val start_date: String
)