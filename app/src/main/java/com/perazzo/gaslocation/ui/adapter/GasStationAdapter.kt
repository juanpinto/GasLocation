package com.perazzo.gaslocation.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.perazzo.gaslocation.api.models.GasStation
import com.perazzo.gaslocation.ui.item.GasStationItem

class GasStationAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var gasStations : List<GasStation> = ArrayList()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val item = holder?.itemView as GasStationItem
        item.onBind(gasStations[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = GasStationItem(parent!!.context)
        return object : RecyclerView.ViewHolder(view){}
    }

    override fun getItemId(position: Int): Long {
        return gasStations[position].id.toLong()
    }

    override fun getItemCount(): Int {
        return gasStations.size
    }
}