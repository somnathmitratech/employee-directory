package com.somnathmitra.android.employeedirectory.data.remote

import com.somnathmitra.android.employeedirectory.data.model.EmployeesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface NetworkService {

    @GET("/sq-mobile-interview/employees.json")
    fun getEmployees() : Single<EmployeesResponse>

    @GET("/sq-mobile-interview/employees_malformed.json")
    fun getMalformedResponseEmployees() : Single<EmployeesResponse>

    @GET("sq-mobile-interview/employees_empty.json")
    fun getEmptyResponse() : Single<EmployeesResponse>
}