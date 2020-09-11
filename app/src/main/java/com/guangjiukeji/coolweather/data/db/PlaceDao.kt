package com.guangjiukeji.coolweather.data.db

import androidx.lifecycle.MutableLiveData
import com.guangjiukeji.coolweather.data.model.place.Province
import org.litepal.LitePal

/**
 * Author:sunchenghao
 * Date:2020/9/11.16:59
 * Describe
 **/
class PlaceDao {

    fun getProvinceList(): MutableList<Province> = LitePal.findAll(Province::class.java)

    fun getCityList(provinceId: Int) : MutableList<Province> = LitePal.where(provinceId.toString()).find(City::)
}