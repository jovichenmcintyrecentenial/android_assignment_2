package com.centennial.jovichenmcintyre_mapd711_001_assignment2.models

class Phone(
    company: String,
    name: String,
    price: String,
    uri: String
) {

    var company:String = company
    var name:String = name
    var price:String = price
    var uri:String = uri

    fun getFormatterPrice():String{
        return this.price
    }

}

