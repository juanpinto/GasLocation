package com.perazzo.gaslocation.di.module

import android.content.Context
import com.perazzo.gaslocation.ui.GasApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val gasApplication: GasApplication) {

    @Provides
    @Singleton
    fun appContext(): Context {
        return gasApplication
    }
}