package com.guangjiukeji.coolweather.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.guangjiukeji.coolweather.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        if (viewModel.isWeatherCached()){

        }else{
            supportFragmentManager.beginTransaction().replace(R.id.container,ChooseAreaFragment()).commit()
        }
    }


}