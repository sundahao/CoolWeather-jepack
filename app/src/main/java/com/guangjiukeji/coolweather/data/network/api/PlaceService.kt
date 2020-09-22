package com.guangjiukeji.coolweather.data.network.api

import com.guangjiukeji.coolweather.data.model.place.City
import com.guangjiukeji.coolweather.data.model.place.County
import com.guangjiukeji.coolweather.data.model.place.Province
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Author:sunchenghao
 * Date:2020/9/15.16:23
 * Describe
 **/
interface PlaceService {

    @GET("api/china")
    fun getProvince(): Call<MutableList<Province>>

    @GET("api/china/{provinceId}")
    fun getCities(@Path("provinceId") provinceId: Int): Call<MutableList<City>>

    @GET("api/china/{provinceId}/{cityId}")
    fun getCounties(@Path("provinceId") provinceId: Int, @Path("cityId") cityId: Int): Call<MutableList<County>>
}