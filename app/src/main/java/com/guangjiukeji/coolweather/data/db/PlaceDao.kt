package com.guangjiukeji.coolweather.data.db

import com.guangjiukeji.coolweather.data.model.place.City
import com.guangjiukeji.coolweather.data.model.place.County
import com.guangjiukeji.coolweather.data.model.place.Province
import org.litepal.LitePal

/**
 * Author:sunchenghao
 * Date:2020/9/11.16:59
 * Describe
 **/
class PlaceDao {

    fun getProvinceList(): MutableList<Province> = LitePal.findAll(Province::class.java)

    fun getCityList(provinceId: Int) : MutableList<City> = LitePal.where("provinceId = ?",provinceId.toString()).find(City::class.java)

    fun getCountyList(cityId: Int) : MutableList<County> =LitePal.where("cityId = ?",cityId.toString()).find(County::class.java)

    fun saveProvinceList(provinceList:List<Province>?){
        if (provinceList != null && provinceList.isNotEmpty()){
            LitePal.saveAll(provinceList)
        }
    }

    fun saveCityList(cityList:List<City>?){
        if (cityList != null && cityList.isNotEmpty()){
            LitePal.saveAll(cityList)
        }
    }

    fun saveCountyList(countyList:List<County>?) {
        if (countyList != null && countyList.isNotEmpty()){
            LitePal.saveAll(countyList)
        }
    }
}