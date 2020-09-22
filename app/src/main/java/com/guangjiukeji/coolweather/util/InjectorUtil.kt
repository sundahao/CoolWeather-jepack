package com.guangjiukeji.coolweather.util


import com.guangjiukeji.coolweather.data.PlaceRepository
import com.guangjiukeji.coolweather.data.WeatherRepository
import com.guangjiukeji.coolweather.data.db.CoolWeatherDatabase
import com.guangjiukeji.coolweather.data.network.CoolWeatherNetwork
import com.guangjiukeji.coolweather.ui.MainModelFactory
import com.guangjiukeji.coolweather.ui.area.ChooseAreaModelFactory
import com.guangjiukeji.coolweather.ui.weather.WeatherModelFactory

object InjectorUtil {

    private fun getPlaceRepository() = PlaceRepository.getInstance(CoolWeatherDatabase.getPlaceDao(), CoolWeatherNetwork.getInstance())

    private fun getWeatherRepository() = WeatherRepository.getInstance(CoolWeatherDatabase.getWeatherDao(), CoolWeatherNetwork.getInstance())

    fun getChooseAreaModelFactory() = ChooseAreaModelFactory(getPlaceRepository())

    fun getWeatherModelFactory() = WeatherModelFactory(getWeatherRepository())

    fun getMainModelFactory() = MainModelFactory(getWeatherRepository())

}