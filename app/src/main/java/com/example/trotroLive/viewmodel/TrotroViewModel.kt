package com.example.trotroLive.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trotroLive.R
import com.example.trotroLive.data.BusStop
import com.example.trotroLive.data.Trotro
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*

class TrotroViewModel(private val trotroRepository: Trotro) : ViewModel() {

    private val _trotros = MutableLiveData<List<Trotro>>()
    val trotros: LiveData<List<Trotro>> = _trotros

    fun getTrotros() {
        viewModelScope.launch {
            val trotros = trotroRepository.getTrotros()
            _trotros.value = trotros
        }
    }

}
