package com.somnathmitra.android.employeedirectory.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.somnathmitra.android.employeedirectory.data.model.Employee
import com.somnathmitra.android.employeedirectory.data.remote.NetworkService
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class EmployeesListViewModel(
    private val compositeDisposable: CompositeDisposable,
    private val networkService : NetworkService) {

    val employees = MutableLiveData<List<Employee>>()

    companion object{
        const val TAG = "EmployeesListViewModel"
    }

    fun getEmployees(){
        compositeDisposable.add(
            networkService.getEmployees()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.d(TAG, "Received employees response = ${it.employees.size}")
                        employees.postValue(it.employees)


                    },
                    {
                        Log.e(TAG, " Error. ${it.message}")
                    }
                )
        )
    }

    fun onDestroy(){
        compositeDisposable.dispose()
    }

}