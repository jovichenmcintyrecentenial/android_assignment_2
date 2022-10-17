package com.centennial.jovichenmcintyre_mapd711_001_assignment2.models
//Name: Jovi Chen-Mcintyre
//ID: 301125059
import java.text.NumberFormat
import java.util.*

class Phone(
    name: String,
    price: Double,
    uri: String,
    company: String
) {

    var name:String = name
    private var price:Double = price
    var uri:String = uri
    var company:String = company

    fun getFormatterPrice(): String {
        return "$"+NumberFormat.getNumberInstance(Locale.US).format(price);
    }

}

