package com.somnathmitra.android.employeedirectory.di.module

import android.content.Context
import com.somnathmitra.android.employeedirectory.MyApplication
import com.somnathmitra.android.employeedirectory.data.remote.NetworkService
import com.somnathmitra.android.employeedirectory.data.remote.Networking
import com.somnathmitra.android.employeedirectory.di.ApplicationContext
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ApplicationModule(private val application : MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext() : Context = application

    @Provides
    fun provideCompositeDisposable() : CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideNetworkService() : NetworkService =
        Networking.create(application.cacheDir,10 * 10 * 1024)


}