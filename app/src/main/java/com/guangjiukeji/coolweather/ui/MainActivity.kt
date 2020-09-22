package com.guangjiukeji.coolweather.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.guangjiukeji.coolweather.R
import com.guangjiukeji.coolweather.ui.area.ChooseAreaFragment
import com.guangjiukeji.coolweather.ui.weather.WeatherActivity
import com.guangjiukeji.coolweather.util.InjectorUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this, InjectorUtil.getMainModelFactory()).get(MainViewModel::class.java)
        if (viewModel.isWeatherCached()){
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.container,ChooseAreaFragment()).commit()
        }
    }

}