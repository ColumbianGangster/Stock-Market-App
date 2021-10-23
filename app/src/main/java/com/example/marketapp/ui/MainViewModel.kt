package com.example.marketapp.ui

import androidx.lifecycle.ViewModel
import com.example.marketapp.data.StockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val stockRepository: StockRepository) : ViewModel() {


    fun getSentiments() {

    }

}