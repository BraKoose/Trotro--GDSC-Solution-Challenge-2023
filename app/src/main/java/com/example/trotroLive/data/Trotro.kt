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

val trotros = listOf(
    Trotro(
        "Kwame Nkrumah Circle",
        BusStop("Kaneshie", "Odorkor", 10 to "GHS"),
        "Circle",
        "GPRTU",
        Date(),
        R.drawable.tudu_station
    ),
    Trotro(
        "Accra Mall",
        BusStop("37", "Madina", 4 to "GHS"),
        "Accra Mall",
        "VIP",
        Date(),
        R.drawable.tirtyseven
    ),
    Trotro(
        "Osu",
        BusStop("Labone", "Kanda", 10 to "GHS"),
        "Osu",
        "Providence",
        Date(),
        R.drawable.trotros
    ),
    Trotro(
        "Dansoman",
        BusStop("Sakaman", "Mataheko", 4 to "GHS"),
        "Dansoman",
        "Ghana Private Road Transport Union",
        Date(),
        R.drawable.tudu_station
    ),
    Trotro(
        "Tema Station",
        BusStop("Tema Roundabout", "Community 9", 8 to "GHS"),
        "Tema Station",
        "Omega",
        Date(),
        R.drawable.tirtyseven
    ),
    Trotro(
        "Ashaiman",
        BusStop("Adenta", "Aburi", 4 to "GHS"),
        "Ashaiman",
        "Metro Mass",
        Date(),
        R.drawable.station_kn_circle
    ),
    Trotro(
        "Achimota",
        BusStop("Dome", "Ofankor", 6 to "GHS"),
        "Achimota",
        "Progressive",
        Date(),
        R.drawable.tirtyseven
    ),
    Trotro(
        "Kaneshie",
        BusStop("Circle", "Kasoa", 5 to "GHS"),
        "Kaneshie",
        "GPRTU",
        Date(),
        R.drawable.tudu_station
    ),
    Trotro(
        "Madina",
        BusStop("Adenta", "East Legon", 2 to "GHS"),
        "Madina",
        "VIP",
        Date(),
        R.drawable.station_kn_circle
    ),
    Trotro(
        "Circle to Tema",
        BusStop("Dzorwulu", "Spintex", 8 to "GHS"),
        "Tema",
        "Providence",
        Date(),
        R.drawable.tirtyseven
    )
)


data class BusStop(
    val name: String,
    val sequence: String,
    val fare: Pair<Int, String>
)