package com.murad.details.model

data class Alerts(
    val alertId : Int,
    var country : String,
    var system : String,
    var subsystem : String,
    var ip : String,
    var description :String,
    var startTime : String ,
    var severity : String
)
