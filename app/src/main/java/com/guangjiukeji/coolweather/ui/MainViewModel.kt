package com.guangjiukeji.coolweather.ui

import androidx.lifecycle.ViewModel
import com.guangjiukeji.coolweather.data.WeatherRepository

class MainViewModel(private val repository: WeatherRepository) : ViewModel() {

    fun isWeatherCached() = repository.isWeatherCached()

}