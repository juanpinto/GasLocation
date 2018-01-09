package com.perazzo.gaslocation.di.module

import android.content.Context
import com.perazzo.gaslocation.api.controller.LocationController
import com.perazzo.gaslocation.api.controller.StationController
import com.perazzo.gaslocation.api.service.GasStationApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ControllerModule {

    @Provides
    @Singleton
    fun stationController(stationApi: GasStationApi): StationController {
        return StationController(stationApi)
    }

    @Provides
    @Singleton
    fun locationController(context: Context): LocationController {
        return LocationController(context)
    }
}