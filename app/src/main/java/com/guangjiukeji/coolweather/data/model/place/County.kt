package com.guangjiukeji.coolweather.data.model.place

import com.google.gson.annotations.SerializedName
import org.litepal.crud.LitePalSupport

/**
 * Author:sunchenghao
 * Date:2020/9/14.10:24
 * Describe
 **/
class County(@SerializedName("name") val countyName:String,@SerializedName("weather_id") val weatherId:String) :LitePalSupport() {
    @Transient val id = 0
    var cityId = 0
}