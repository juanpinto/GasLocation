package com.perazzo.gaslocation.utils.binding_adapters

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.perazzo.gaslocation.api.models.GasStation
import com.perazzo.gaslocation.ui.adapter.GasStationAdapter

@BindingAdapter("updateData")
fun updateData(recyclerView: RecyclerView, gasStations: List<GasStation>) {
    val gasStationAdapter = recyclerView.adapter as GasStationAdapter
    gasStationAdapter.gasStations = gasStations
    gasStationAdapter.notifyDataSetChanged()
}