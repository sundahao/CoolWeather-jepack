package com.guangjiukeji.coolweather.data.db

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.guangjiukeji.coolweather.CoolWeatherApplication
import com.guangjiukeji.coolweather.data.model.weather.Weather

/**
 * Author:sunchenghao
 * Date:2020/9/10.15:13
 * Describe
 **/
class WeatherDao {
    
    fun cacheWeatherInfo(weather: Weather?) {
        if (weather == null) return
        PreferenceManager.getDefaultSharedPreferences(CoolWeatherApplication.context).edit {
            val weatherInfo = Gson().toJson(weather)
            putString("weather", weatherInfo)
        }
    }
    
    
    fun getCachedWeatherInfo(): Weather? {
        val weatherInfo =
            PreferenceManager.getDefaultSharedPreferences(CoolWeatherApplication.context)
                .getString("weather", null)
        if (weatherInfo != null) {
            return Gson().fromJson(weatherInfo, Weather::class.java)
        }
        return null
    }
    
    fun cacheBingPic(bingPic: String?) {
        if (bingPic == null) return
        PreferenceManager.getDefaultSharedPreferences(CoolWeatherApplication.context).edit {
            putString("bing_pic", bingPic)
        }
    }
    
    fun getCachedBingPic(): String? =
        PreferenceManager.getDefaultSharedPreferences(CoolWeatherApplication.context)
            .getString("bing_pic", null)
    
    private fun SharedPreferences.edit(action: SharedPreferences.Editor.() -> Unit) {
        val editor = edit()
        action(editor)
        editor.apply()
        
    }
}