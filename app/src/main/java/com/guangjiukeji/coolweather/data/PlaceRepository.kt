package com.guangjiukeji.coolweather.data

import com.guangjiukeji.coolweather.data.db.PlaceDao
import com.guangjiukeji.coolweather.data.network.CoolWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Author:sunchenghao
 * Date:2020/9/11.16:56
 * Describe
 **/
class PlaceRepository private constructor(
    private val placeDao: PlaceDao,
    private val network: CoolWeatherNetwork
) {

    suspend fun getCityList(provinceId: Int) = withContext(Dispatchers.IO) {
        var list = placeDao.getCityList(provinceId)
        if (list.isEmpty()) {
            list = network.fetchCityList(provinceId)
            list.forEach { it.provinceId = provinceId }
            placeDao.saveCityList(list)
        }
        list
    }

    suspend fun getProvinceList() = withContext(Dispatchers.IO) {
        var list = placeDao.getProvinceList()
        if (list.isEmpty()) {
            list = network.fetchProvinceList()
            placeDao.saveProvinceList(list)
        }
        list
    }

    suspend fun getCountyList(provinceId: Int, cityId: Int) = withContext(Dispatchers.IO) {
        var list = placeDao.getCountyList(cityId)
        if (list.isEmpty()){
            list = network.fetchCountyList(provinceId,cityId)
            placeDao.saveCountyList(list)
        }
        list
    }

    companion object {

        private var instance: PlaceRepository? = null

        fun getInstance(placeDao: PlaceDao, network: CoolWeatherNetwork): PlaceRepository {
            if (instance == null) {
                synchronized(PlaceRepository::class.java) {
                    if (instance == null) {
                        instance = PlaceRepository(placeDao, network)
                    }
                }
            }
            return instance!!
        }

    }
}