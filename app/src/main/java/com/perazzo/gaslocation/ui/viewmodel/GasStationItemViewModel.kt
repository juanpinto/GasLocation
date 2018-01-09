package com.perazzo.gaslocation.ui.viewmodel

import android.content.Context
import android.text.Spannable
import com.perazzo.gaslocation.R
import com.perazzo.gaslocation.api.models.GasStation
import com.perazzo.gaslocation.utils.SpannableUtils
import javax.inject.Inject

class GasStationItemViewModel( item: GasStation): BaseViewModel() {

    @Inject
    lateinit var context: Context

    val title: String

    val address: String

    val regPrice: Spannable

    val midPrice: Spannable

    val prePrice: Spannable

    val dieselPrice: Spannable

    init{
        getComponent().inject(this)

        title = context.getString(R.string.copy_gas_station_title, item.station, item.distance)
        address = context.getString(R.string.copy_address, item.address, item.city)
        regPrice = SpannableUtils.buildSpannable(context.getString(R.string.copy_regular_price), "\n" + item.regularGasPrice)
        midPrice = SpannableUtils.buildSpannable(context.getString(R.string.copy_medium_price),"\n" + item.plusGasPrice)
        prePrice = SpannableUtils.buildSpannable(context.getString(R.string.copy_supreme_price), "\n" + item.supperGasPrice)
        dieselPrice = SpannableUtils.buildSpannable(context.getString(R.string.copy_diesel_price), "\n" + item.dieselPrice)
    }
}