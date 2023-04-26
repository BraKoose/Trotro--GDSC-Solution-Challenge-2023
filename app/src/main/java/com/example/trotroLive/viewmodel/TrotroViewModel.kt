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

    fun getTrotro(index: Int): Trotro? {
        return _trotros.value?.getOrNull(index)
    }

    // Function to fetch Trotro data (replace with actual implementation)
    private fun fetchTrotrosData(): List<Trotro> {
        // Replace with actual implementation to fetch Trotro data
        // from repository or other data source
        return listOf(
            Trotro(
                "Kwame Nkrumah Circle",
                BusStop("Kaneshie", "Odorkor", 10 to "GHS"),
                "Circle",
                "GPRTU",
                Date(),
                R.drawable.tudu_station
            ),
            // Add more Trotro objects here
        )
    }

}
