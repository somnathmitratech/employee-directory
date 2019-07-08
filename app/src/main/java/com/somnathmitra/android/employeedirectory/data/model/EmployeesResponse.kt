package com.somnathmitra.android.employeedirectory.data.model

import com.google.gson.annotations.SerializedName

data class EmployeesResponse (

    @SerializedName("employees")
    var employees : List<Employee>

)