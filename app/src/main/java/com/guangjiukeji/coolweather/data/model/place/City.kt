package com.guangjiukeji.coolweather.data.model.place

import com.google.gson.annotations.SerializedName
import org.litepal.LitePal
import org.litepal.crud.LitePalSupport

/**
 * Author:sunchenghao
 * Date:2020/9/11.19:46
 * Describe
 **/
class City (@SerializedName("name") val cityName:String,@SerializedName("id") val cityCode:Int) :LitePalSupport() {

}