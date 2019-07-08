package com.somnathmitra.android.employeedirectory

import android.app.Application
import com.somnathmitra.android.employeedirectory.data.remote.NetworkService
import com.somnathmitra.android.employeedirectory.di.components.ApplicationComponent
import com.somnathmitra.android.employeedirectory.di.components.DaggerApplicationComponent
import com.somnathmitra.android.employeedirectory.di.module.ApplicationModule
import javax.inject.Inject

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var networkService: NetworkService

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    fun getDependencies(){
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

}