package com.perazzo.gaslocation.ui

import android.app.Application
import com.perazzo.gaslocation.di.component.AppComponent
import com.perazzo.gaslocation.di.component.DaggerAppComponent
import com.perazzo.gaslocation.di.module.AppModule

class GasApplication: Application() {

    lateinit var appComponent: AppComponent

    companion object {

        lateinit var instance: GasApplication

        fun get(): GasApplication {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        updateDagger()

    }

    private fun updateDagger() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }



}