package com.perazzo.gaslocation.ui.viewmodel

import android.databinding.BaseObservable
import android.databinding.ObservableBoolean
import com.perazzo.gaslocation.di.component.DaggerViewModelComponent
import com.perazzo.gaslocation.di.component.ViewModelComponent
import com.perazzo.gaslocation.ui.GasApplication

open class BaseViewModel: BaseObservable() {

    val loaderVisibility: ObservableBoolean = ObservableBoolean()

    init {
        loaderVisibility.set(false)
    }

    fun getComponent(): ViewModelComponent {
        return DaggerViewModelComponent.builder()
                .appComponent(GasApplication.get().appComponent)
                .build()
    }
}