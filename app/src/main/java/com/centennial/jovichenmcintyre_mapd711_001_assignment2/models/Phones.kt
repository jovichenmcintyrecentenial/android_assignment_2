package com.centennial.jovichenmcintyre_mapd711_001_assignment2.models

class Phone(
    name: String,
    price: Double,
    uri: String
) {

    var name:String = name
    private var price:Double = price
    var uri:String = uri

    fun getFormatterPrice():Double{
        return this.price
    }

}

