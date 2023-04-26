package com.example.trotroLive.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.trotroLive.R
import com.example.trotroLive.data.BusStop
import com.example.trotroLive.data.Trotro
import java.util.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TrotroViewModel : ViewModel() {

    private val _trotros = MutableLiveData<List<Trotro>>()
    val trotros: LiveData<List<Trotro>>
        get() = _trotros

    init {
        getTrotros()
    }

    private fun getTrotros() {
        // Fetch Trotro data from repository or other data source
        val trotrosList = fetchTrotrosData()

        // Update _trotros MutableLiveData with fetched data
        _trotros.value = trotrosList
    }

    // Function to fetch Trotro data (replace with actual implementation)
    private fun fetchTrotrosData(): List<Trotro> {
        // Replace with actual implementation to fetch Trotro data
        // from repository or other data source
        return listOf(
            Trotro(
                "Atonsu High School",
                BusStop("High School junction", "Adum", 5 to "GHS"),
                "Kejetia",
                "GPRTU",
                Date(),
                R.drawable.tudu_station
            ),
            // Add more Trotro objects here

            Trotro(
                "Tech Station",
                BusStop("KNUST", "Kotei", 2 to "GHS"),
                "Atonsu",
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
    }

}
