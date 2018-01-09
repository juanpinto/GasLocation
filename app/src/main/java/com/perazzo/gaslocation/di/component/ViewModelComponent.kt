package com.perazzo.gaslocation.di.component

import com.perazzo.gaslocation.di.scope.ActivityScope
import com.perazzo.gaslocation.ui.viewmodel.GasStationItemViewModel
import com.perazzo.gaslocation.ui.viewmodel.GasStationsViewModel
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class))
interface ViewModelComponent: AppComponent {

    fun inject(stationViewModelGas: GasStationsViewModel)

    fun inject(gasStationsViewModel: GasStationItemViewModel)
}