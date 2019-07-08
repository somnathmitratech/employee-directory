package com.somnathmitra.android.employeedirectory.di.module

import android.content.Context
import android.net.Network
import androidx.appcompat.app.AppCompatActivity
import com.somnathmitra.android.employeedirectory.di.ActivityContext
import com.somnathmitra.android.employeedirectory.util.NetworkUtil
import dagger.Module
import dagger.Provides

@Module
class ActivityModule ( val activity : AppCompatActivity) {

    @Provides
    @ActivityContext
    fun provideContext() : Context = activity

    @Provides
    fun provideNetworUtil() : NetworkUtil = NetworkUtil(activity)
}