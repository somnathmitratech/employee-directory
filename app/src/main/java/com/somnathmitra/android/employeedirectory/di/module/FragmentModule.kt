package com.somnathmitra.android.employeedirectory.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import com.somnathmitra.android.employeedirectory.MyApplication
import com.somnathmitra.android.employeedirectory.di.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class FragmentModule (private val fragment: Fragment) {

    @ApplicationContext
    @Provides
    fun provideContext() : Context = fragment.activity!!.application as MyApplication
}