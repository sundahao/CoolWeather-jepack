package com.guangjiukeji.coolweather.data

import com.guangjiukeji.coolweather.data.db.WeatherDao
import com.guangjiukeji.coolweather.data.model.weather.Weather
import com.guangjiukeji.coolweather.data.network.CoolWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Author:sunchenghao
 * Date:2020/9/10.15:11
 * Describe
 **/
class WeatherRepository private constructor(private val weatherDao: WeatherDao,
                                            private val network: CoolWeatherNetwork) {
    
    fun isWeatherCached() = weatherDao.getCachedWeatherInfo() != null
    
    suspend fun refreshBingPic() = requestBingPic()
    
    private suspend fun requestBingPic() = withContext(Dispatchers.IO) {
        val url = network.fetchBingPic()
        weatherDao.cacheBingPic(url)
        url
    }
    
    suspend fun getWeather(weatherId: String): Weather {
        var weather = weatherDao.getCachedWeatherInfo()
        if (weather == null) weather = requestWeather(weatherId)
        return weather
    }
    
    private suspend fun requestWeather(weatherId: String) = withContext(Dispatchers.IO) {
        val heWeather = network.fetchWeather(weatherId)
        val weather = heWeather.weather!![0]
        weatherDao.cacheWeatherInfo(weather)
        weather
        
    }
    
    suspend fun getBingPic(): String {
        var url = weatherDao.getCachedBingPic()
        if (url == null) url = requestBingPic()
        return url
    }
    
    fun getCachedWeather() = weatherDao.getCachedWeatherInfo()!!
    
    
    companion object {
        
        private lateinit var instance: WeatherRepository
        
        fun getInstance(weatherDao: WeatherDao, network: CoolWeatherNetwork): WeatherRepository {
            if (!::instance.isInitialized) {
                synchronized(WeatherRepository::class.java) {
                    if (!::instance.isInitialized) {
                        instance = WeatherRepository(weatherDao, network)
                    }
                }
            }
            return instance
        }
        
    }
    
}