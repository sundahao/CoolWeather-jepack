package com.guangjiukeji.coolweather.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Author:sunchenghao
 * Date:2020/9/15.15:49
 * Describe
 **/
object ServiceCreator {

    //public static final
    private const val BASE_URL = "http://guolin.tech/"

    private val httpClient = OkHttpClient.Builder()

    private val buidler = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient.build())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
    

    private val retrofit = buidler.build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
}