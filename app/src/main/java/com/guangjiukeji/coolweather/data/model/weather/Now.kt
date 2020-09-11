package com.guangjiukeji.coolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * Author:sunchenghao
 * Date:2020/9/11.14:26
 * Describe
 **/
class Now {
    @SerializedName("tmp")
    var temperature = ""
    @SerializedName("cond")
    lateinit var more: More

    fun degree() = "$temperature℃"

    inner class More {
        @SerializedName("txt")
        var info = ""
    }
}