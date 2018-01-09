package com.perazzo.gaslocation.ui.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.perazzo.gaslocation.R
import com.perazzo.gaslocation.databinding.ActivityMainBinding
import com.perazzo.gaslocation.di.component.ActivityComponent
import com.perazzo.gaslocation.di.component.DaggerActivityComponent
import com.perazzo.gaslocation.ui.GasApplication
import com.perazzo.gaslocation.ui.adapter.GasStationAdapter
import com.perazzo.gaslocation.ui.viewmodel.GasStationsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var activityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getComponent().inject(this)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityBinding.viewModel = GasStationsViewModel()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val gasStationsAdapter = GasStationAdapter()
        gasStationsAdapter.setHasStableIds(true)

        val layoutManager = LinearLayoutManager(this)
        activityBinding.recyclerViewGasStations.layoutManager = layoutManager
        activityBinding.recyclerViewGasStations.adapter = gasStationsAdapter
    }

    private fun getComponent(): ActivityComponent {
        return DaggerActivityComponent.builder()
                .appComponent(GasApplication.get().appComponent)
                .build()
    }

}