package com.somnathmitra.android.employeedirectory.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.somnathmitra.android.employeedirectory.data.model.Employee
import com.somnathmitra.android.employeedirectory.data.remote.NetworkService
import com.somnathmitra.android.employeedirectory.data.validator.EmployeeValidator
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EmployeesListViewModel @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    private val networkService : NetworkService) {

    val employees = MutableLiveData<ArrayList<Employee>>()

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
                        employees.postValue(EmployeeValidator.cleanData(it.employees).apply {
                            Log.d(TAG,"Cleaned list = ${this.size}")
                        })
                    },
                    {
                        Log.e(TAG, " Error. ${it.message}")
                    }
                )
        )
    }

    fun getEmployeesMalformedResponse(){
        compositeDisposable.add(
            networkService.getMalformedResponseEmployees()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.d(TAG, "Received employees response = ${it.employees.size}")
                        employees.postValue(EmployeeValidator.cleanData(it.employees).apply {
                            Log.d(TAG,"Cleaned list = ${this.size}")
                        })
                    },
                    {
                        Log.e(TAG, " Error. ${it.message}")
                    }
                )
        )
    }

    fun getEmptyResponse(){
        compositeDisposable.add(
            networkService.getEmptyResponse()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.d(TAG, "Received employees response = ${it.employees.size}")
                        employees.postValue(EmployeeValidator.cleanData(it.employees))
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