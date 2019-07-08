package com.somnathmitra.android.employeedirectory

import android.app.Application
import com.somnathmitra.android.employeedirectory.data.remote.NetworkService
import com.somnathmitra.android.employeedirectory.data.remote.Networking
import io.reactivex.disposables.CompositeDisposable

class MyApplication : Application() {

    lateinit var compositeDisposable: CompositeDisposable
    lateinit var networkService: NetworkService

    override fun onCreate() {
        super.onCreate()

        compositeDisposable = CompositeDisposable()
        networkService = Networking.create(cacheDir,10 * 10 * 1024)
    }

}