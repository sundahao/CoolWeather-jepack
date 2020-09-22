package com.guangjiukeji.coolweather.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guangjiukeji.coolweather.data.WeatherRepository

/**
 * Author:sunchenghao
 * Date:2020/9/16.17:28
 * Describe
 **/
class MainModelFactory(private val repository: WeatherRepository) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}