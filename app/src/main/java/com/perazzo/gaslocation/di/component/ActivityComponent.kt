package com.perazzo.gaslocation.di.component

import com.perazzo.gaslocation.di.scope.ActivityScope
import com.perazzo.gaslocation.ui.activity.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class))
interface ActivityComponent: AppComponent {

    fun inject(mainActivity: MainActivity)

}