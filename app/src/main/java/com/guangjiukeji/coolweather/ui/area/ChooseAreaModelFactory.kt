package com.guangjiukeji.coolweather.ui.area

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guangjiukeji.coolweather.data.PlaceRepository

/**
 * Author:sunchenghao
 * Date:2020/9/16.17:00
 * Describe
 **/
class ChooseAreaModelFactory(private val repository: PlaceRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ChooseAreaViewModel(repository) as T
    }
}