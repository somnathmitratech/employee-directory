package com.somnathmitra.android.employeedirectory.util

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import com.somnathmitra.android.employeedirectory.di.ActivityContext
import javax.inject.Inject

class NetworkUtil @Inject constructor(
    @ActivityContext private val activity: AppCompatActivity) {

    fun isNetworkConnected () : Boolean {
        val connectivityManager=activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo=connectivityManager.activeNetworkInfo
        return  networkInfo!=null && networkInfo.isConnected
    }
}