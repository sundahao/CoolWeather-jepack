package com.guangjiukeji.coolweather.data.model.place

import com.google.gson.annotations.SerializedName
import org.litepal.crud.LitePalSupport

/**
 * Author:sunchenghao
 * Date:2020/9/11.17:01
 * Describe
 **/
class Province(@SerializedName("name") val provinceName: String,@SerializedName("id") val  provinceCode: Int) : LitePalSupport() {
    @Transient val id = 0
}