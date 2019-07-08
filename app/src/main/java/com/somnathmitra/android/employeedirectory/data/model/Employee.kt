package com.somnathmitra.android.employeedirectory.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Employee (

    @Expose
    @SerializedName("uuid")
    val id : String,

    @Expose
    @SerializedName("full_name")
    val fullName : String,

    @Expose
    @SerializedName("phone_number")
    val phoneNumber : String,

    @Expose
    @SerializedName("email_address")
    val emailAddress : String,

    @Expose
    @SerializedName("biography")
    val biography : String,

    @Expose
    @SerializedName("photo_url_small")
    val photoUrlSmall : String,

    @Expose
    @SerializedName("photo_url_large")
    val photoUrlLarge : String,

    @Expose
    @SerializedName("team")
    val team : String,

    @Expose
    @SerializedName("employee_type")
    val employeeType : String
) {

    fun isValid() : Boolean{

        // check required fields
        // assuming full_name / phone number / email address are id
        // are required fields
        return !id.isNullOrEmpty() &&
                !fullName.isNullOrEmpty() &&
                !phoneNumber.isNullOrEmpty() &&
                !emailAddress.isNullOrEmpty()

    }
}