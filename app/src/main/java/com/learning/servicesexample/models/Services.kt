package com.learning.servicesexample.models


import com.google.gson.annotations.SerializedName

data class Service(
    @SerializedName("serviceName")
    val serviceName: String,
    @SerializedName("serviceTime")
    val serviceTime: String,
    @SerializedName("days")
    val days: List<Day>,
)

data class Day(
    @SerializedName("dayName")
    val day: String,
    @SerializedName("day")
    val time: String

)