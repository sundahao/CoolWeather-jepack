package com.guangjiukeji.coolweather.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guangjiukeji.coolweather.data.WeatherRepository

/**
 * Author:sunchenghao
 * Date:2020/9/22.15:05
 * Describe
 **/
class WeatherModelFactory(private val repository:WeatherRepository) :ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(repository) as T
    }
}