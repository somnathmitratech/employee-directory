package com.somnathmitra.android.employeedirectory.di.components

import com.somnathmitra.android.employeedirectory.di.FragmentScope
import com.somnathmitra.android.employeedirectory.di.module.FragmentModule
import com.somnathmitra.android.employeedirectory.ui.EmployeesListFragment
import dagger.Component

@FragmentScope
@Component(modules = [FragmentModule::class],dependencies = [ApplicationComponent::class])
interface EmployeeListFragmentComponent{

    fun inject(fragment : EmployeesListFragment)
}