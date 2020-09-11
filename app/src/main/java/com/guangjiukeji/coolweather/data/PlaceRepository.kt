package com.guangjiukeji.coolweather.data

/**
 * Author:sunchenghao
 * Date:2020/9/11.16:56
 * Describe
 **/
class PlaceRepository private constructor(private val placeDao:PlaceDao,private val network:CoolWeatherNetwork){
}