package com.guangjiukeji.coolweather.util

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.guangjiukeji.coolweather.R
import com.guangjiukeji.coolweather.data.model.weather.Weather
import com.guangjiukeji.coolweather.databinding.ForecastItemBinding

/**
 * Author:sunchenghao
 * Date:2020/9/21.19:25
 * Describe
 **/

@BindingAdapter("loadBingPic")
    fun ImageView.loadBingPic(url: String?) {
    if (url != null) Glide.with(context).load(url).into(this)
}

@BindingAdapter("colorSchemeResources")
fun SwipeRefreshLayout.colorSchemeResources(resId: Int) {
    setColorSchemeResources(resId)
}

@BindingAdapter("showForecast")
fun LinearLayout.showForecast(weather: Weather?) = weather?.let {
    removeAllViews()
    for (forecast in it.forecastList) {
        val view = LayoutInflater.from(context).inflate(R.layout.forecast_item, this, false)
        DataBindingUtil.bind<ForecastItemBinding>(view)?.forecast = forecast
        addView(view)
    }
}