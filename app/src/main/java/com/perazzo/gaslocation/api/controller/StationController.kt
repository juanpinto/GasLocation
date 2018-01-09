package com.perazzo.gaslocation.api.controller

import com.perazzo.gaslocation.api.models.GasStation
import com.perazzo.gaslocation.api.models.GasStationResponse
import com.perazzo.gaslocation.api.service.GasStationApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class StationController(private val gasStationApi: GasStationApi) {

    fun getStationsByLocation(latitude: Double, longitude: Double): Observable<GasStationResponse> {
        return gasStationApi.getStations(latitude, longitude)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}