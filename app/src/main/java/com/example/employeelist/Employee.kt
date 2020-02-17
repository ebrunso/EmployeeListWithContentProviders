package com.example.employeelist

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Employee(
    var firstName : String,
    var lastName : String,
    var streetAddress : String,
    var city : String,
    var state : String,
    var zip : String,
    var taxID : String,
    var position : String,
    var department : String) : Parcelable