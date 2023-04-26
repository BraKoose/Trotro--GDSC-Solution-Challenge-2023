package com.example.trotroLive.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trotroLive.data.Trotro

class DetailsViewModel : ViewModel() {
    private val _selectedTrotro = MutableLiveData<Trotro>()

    // Collect the bus stops and fare prices state in the view model
    private val _busStops = MutableLiveData<Map<String, Double>?>()
    val busStops: LiveData<Map<String, Double>?>
        get() = _busStops

    private val _farePrices = MutableLiveData<Map<String, Double>?>()
    val farePrices: LiveData<Map<String, Double>?>
        get() = _farePrices

  /*  fun setSelectedTrotro(trotro: Trotro) {
        _selectedTrotro.value = trotro

        // Populate the bus stops and fare prices state from the selected trotro
        _busStops.value = trotro.busStops
    }*/
}