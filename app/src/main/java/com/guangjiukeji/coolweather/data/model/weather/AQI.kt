package com.guangjiukeji.coolweather.data.model.weather

/**
 * Author:sunchenghao
 * Date:2020/9/11.14:12
 * Describe
 **/
class AQI {
    lateinit var city: AQICity

    inner class AQICity {
        var aqi = ""
        var pm25 = ""
    }
}