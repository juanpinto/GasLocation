package com.perazzo.gaslocation.api.service

import com.perazzo.gaslocation.api.models.GasStationResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GasStationApi {

    @GET("/stations/radius/{latitude}/{longitude}/50/diesel/distance/c2aezntxb3.json?")
    fun getStations(@Path("latitude") latitude: Double, @Path("longitude") longitude: Double) : Observable<GasStationResponse>
}