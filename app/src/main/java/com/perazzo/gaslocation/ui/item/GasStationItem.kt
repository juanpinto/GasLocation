package com.perazzo.gaslocation.ui.item

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.perazzo.gaslocation.R
import com.perazzo.gaslocation.api.models.GasStation
import com.perazzo.gaslocation.databinding.ItemGasStationBinding
import com.perazzo.gaslocation.ui.viewmodel.GasStationItemViewModel

class GasStationItem(context: Context): LinearLayout(context) {

    private val gasStationItemBinding: ItemGasStationBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.item_gas_station, this, true)

    fun onBind(gasStation: GasStation) {
        gasStationItemBinding.viewModel = GasStationItemViewModel(gasStation)
    }
}