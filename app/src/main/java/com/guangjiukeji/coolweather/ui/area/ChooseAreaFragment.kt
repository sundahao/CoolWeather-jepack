package com.guangjiukeji.coolweather.ui.area

import android.app.ProgressDialog
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.guangjiukeji.coolweather.R

class ChooseAreaFragment : Fragment() {

    companion object {
        fun newInstance() = ChooseAreaFragment()
    }

    private val viewModel by lazy { ViewModelProvider(this).get(ChooseAreaViewModel::class.java) }
    private var progressDialog:ProgressDialog? = null
    private lateinit var adapter:ArrayAdapter<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.choose_area, container, false);
        DataBindingUtil.bind<choose>(inflate)
        return inflate
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChooseAreaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}