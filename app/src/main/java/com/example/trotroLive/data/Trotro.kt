package com.example.trotroLive.data

import com.example.trotroLive.R
import java.util.*

data class Trotro(
    val stationName: String,
    val busStops: BusStop?,
    val lastDestination: String,
    val agency: String?,
    val lastUpdate: Date,
    val image: Int
)



data class BusStop(
    val name: String,
    val sequence: String,
    val fare: Pair<Int, String>
)