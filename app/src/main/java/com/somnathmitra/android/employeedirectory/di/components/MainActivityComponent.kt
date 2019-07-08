package com.somnathmitra.android.employeedirectory.di.components

import android.content.Context
import com.somnathmitra.android.employeedirectory.di.ActivityContext
import com.somnathmitra.android.employeedirectory.di.ActivityScope
import com.somnathmitra.android.employeedirectory.di.module.ActivityModule
import com.somnathmitra.android.employeedirectory.ui.MainActivity
import com.somnathmitra.android.employeedirectory.util.NetworkUtil
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class],dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    fun inject(activityModule : MainActivity)

    @ActivityContext
    fun getContext() : Context

    fun getNetworkUtil() : NetworkUtil

}