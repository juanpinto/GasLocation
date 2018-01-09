package com.perazzo.gaslocation.api.models

import com.google.gson.annotations.SerializedName


data class GasStation(@SerializedName("id") var id: String,
                      @SerializedName("address") var address: String,
                      @SerializedName("city") var city: String,
                      @SerializedName("country") var country: String,
                      @SerializedName("station") var station: String,
                      @SerializedName("distance") var distance: String,
                      @SerializedName("lat") var latitude: String,
                      @SerializedName("lng") var longitude: String,
                      @SerializedName("reg_price") val regularGasPrice: String,
                      @SerializedName("mid_price") val plusGasPrice: String,
                      @SerializedName("pre_price") val supperGasPrice: String,
                      @SerializedName("diesel_price") val dieselPrice: String)