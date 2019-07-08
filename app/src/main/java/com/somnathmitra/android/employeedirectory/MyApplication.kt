package com.somnathmitra.android.employeedirectory

import android.app.Application
import com.somnathmitra.android.employeedirectory.data.remote.NetworkService
import com.somnathmitra.android.employeedirectory.data.remote.Networking

class MyApplication : Application() {

    lateinit var networkService: NetworkService

    override fun onCreate() {
        super.onCreate()

        networkService = Networking.create(cacheDir,10 * 10 * 1024)
    }

}