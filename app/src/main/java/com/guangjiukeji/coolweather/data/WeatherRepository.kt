package com.guangjiukeji.coolweather.data

import com.guangjiukeji.coolweather.data.db.WeatherDao
import com.guangjiukeji.coolweather.data.network.CoolWeatherNetwork

/**
 * Author:sunchenghao
 * Date:2020/9/10.15:11
 * Describe
 **/
class WeatherRepository private constructor(private val weatherDao: WeatherDao, private val network: CoolWeatherNetwork){

    fun isWeatherCached() = weatherDao.getCachedWeatherInfo() != null
}