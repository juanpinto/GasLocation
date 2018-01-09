package com.perazzo.gaslocation.api.models

import com.google.gson.annotations.SerializedName

data class GasStationResponse(@SerializedName("stations")  val gasStations: List<GasStation>)