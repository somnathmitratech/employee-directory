package com.somnathmitra.android.employeedirectory.di.components

import android.content.Context
import com.somnathmitra.android.employeedirectory.MyApplication
import com.somnathmitra.android.employeedirectory.data.remote.NetworkService
import com.somnathmitra.android.employeedirectory.di.ApplicationContext
import com.somnathmitra.android.employeedirectory.di.module.ApplicationModule
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun getApplicationContext() : Context

    fun getCompositeDisposable() : CompositeDisposable

    fun getNetworkService() : NetworkService

}