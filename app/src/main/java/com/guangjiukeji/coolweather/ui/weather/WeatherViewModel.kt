package com.guangjiukeji.coolweather.ui.weather

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guangjiukeji.coolweather.CoolWeatherApplication
import com.guangjiukeji.coolweather.data.WeatherRepository
import com.guangjiukeji.coolweather.data.model.weather.Weather
import kotlinx.coroutines.launch

/**
 * Author:sunchenghao
 * Date:2020/9/21.18:01
 * Describe
 **/
class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {
    
    var weather = MutableLiveData<Weather>()
    
    var bingPicUrl = MutableLiveData<String>()
    
    var refreshing = MutableLiveData<Boolean>()
    
    var weatherInitialized = MutableLiveData<Boolean>()
    
    var weatherId = ""
    
    fun onRefresh() {
        refreshWeather()
    }
    
    fun refreshWeather() {
        refreshing.value = true
        launch({
            weather.value = repository.getWeather(weatherId)
            weatherInitialized.value = true
            refreshing.value = false
        }, {
            Toast.makeText(CoolWeatherApplication.context, it.message, Toast.LENGTH_SHORT).show()
            refreshing.value = false
        })
        getBingPic(false)
    }
    
    private fun getBingPic(refresh: Boolean) {
        launch({
            bingPicUrl.value = if (refresh) repository.refreshBingPic() else repository.getBingPic()
        }, {
            Toast.makeText(CoolWeatherApplication.context, it.message, Toast.LENGTH_SHORT).show()
        })
        
    }
    
    private fun launch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit) =
        viewModelScope.launch {
            try {
                block()
            } catch (e: Throwable) {
                error(e)
            }
        }
    
    fun isWeatherCached() = repository.isWeatherCached()
    
    fun getCachedWeather() = repository.getCachedWeather()
    
    fun getWeather() {
        launch({
            weather.value = repository.getWeather(weatherId)
            weatherInitialized.value = true
            
        }, {
            Toast.makeText(CoolWeatherApplication.context, it.message, Toast.LENGTH_SHORT).show()
        })
        getBingPic(false)
    }
    
}