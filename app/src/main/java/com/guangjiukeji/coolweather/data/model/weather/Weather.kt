package com.guangjiukeji.coolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * Author:sunchenghao
 * Date:2020/9/10.17:15
 * Describe
 **/
class Weather {
    var status = ""
    lateinit var basic:Basic
    lateinit var aqi:AQI
    lateinit var now:Now
    lateinit var suggestion:Suggestion
    @SerializedName("daily_forecast")
    lateinit var forecastList: List<Forecast>
}