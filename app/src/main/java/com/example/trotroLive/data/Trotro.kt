package com.example.trotroLive.data

import java.util.*

data class Trotro(
    val stationName: String,
    val busStops: Map<String, Double>?,
    val lastDestination: String,
    val agency: String?,
    val lastUpdate: Date,
    val image: Int,
  //  val farePrices: Map<String, Double>?,

)