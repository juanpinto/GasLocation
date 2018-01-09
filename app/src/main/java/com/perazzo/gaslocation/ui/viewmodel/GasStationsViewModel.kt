package com.perazzo.gaslocation.ui.viewmodel

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.location.Location
import com.perazzo.gaslocation.api.controller.LocationController
import com.perazzo.gaslocation.api.controller.StationController
import com.perazzo.gaslocation.api.models.GasStation
import com.perazzo.gaslocation.api.models.GasStationResponse
import javax.inject.Inject

class GasStationsViewModel :BaseViewModel() {

    @Inject
    lateinit var stationController: StationController

    @Inject
    lateinit var locationController: LocationController


    var gasStations: ObservableList<GasStation> = ObservableArrayList()


    init {
        getComponent().inject(this)
        locationController.connect()
        loaderVisibility.set(true)
        locationController.locationSubject.subscribe({result -> locationSuccess(result)}, {error -> onError(error)})
    }

    private fun getGasStations(location: Location)  {
        stationController
                .getStationsByLocation(location.latitude, location.longitude)
                .subscribe({ result -> gasStationSuccess(result)}, {error -> onError(error)})
    }

    private fun locationSuccess(location: Location) {
        locationController.disconnect()
        getGasStations(location)
    }

    private fun gasStationSuccess(gasStationsResponse: GasStationResponse) {
        this.gasStations.clear()
        this.gasStations.addAll(gasStationsResponse.gasStations)
        loaderVisibility.set(false)
    }

    private fun onError(error: Throwable) {
        loaderVisibility.set(false)

    }


}