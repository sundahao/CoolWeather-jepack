package com.guangjiukeji.coolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * Author:sunchenghao
 * Date:2020/9/10.19:29
 * Describe
 **/
class Basic {

    @SerializedName("city")
    var cityName = ""
    @SerializedName("id")
    var weatherId = ""
    lateinit var update: Update

    inner class Update{
        @SerializedName("loc")
        var updateTime = ""

        fun time() = updateTime.split(" ")[1]

    }
}