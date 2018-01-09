package com.perazzo.gaslocation.di.component

import android.content.Context
import com.perazzo.gaslocation.api.controller.LocationController
import com.perazzo.gaslocation.api.controller.StationController
import com.perazzo.gaslocation.di.module.ApiModule
import com.perazzo.gaslocation.di.module.AppModule
import com.perazzo.gaslocation.di.module.ControllerModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class, ControllerModule::class))
interface AppComponent {

    fun context(): Context

    /**
    Controllers
     *
     */

    fun stationController(): StationController

    fun locationController(): LocationController
}