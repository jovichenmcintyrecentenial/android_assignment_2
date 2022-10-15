package com.centennial.jovichenmcintyre_mapd711_001_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.enumerators.PhoneCompany
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.models.Phone
import java.util.ArrayList

class ListOfPhonesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_phones)
    }

    private fun getPhoneList(company: PhoneCompany):List<Phone>{
        var list = ArrayList<Phone>()

        when (company) {
            PhoneCompany.OPPO -> {
                list.add(Phone("Oppo Reno8 Pro",756.81,"oppo-reno8-pro"))
                list.add(Phone("Oppo A77s",303.38,"oppo-a77s"))
                list.add(Phone("Oppo Reno7 5G",488.25,"oppo-reno7"))
            }
            PhoneCompany.GOOGLE -> {
                list.add(Phone("Google Pixel 7 Pro",1179.99,"google-pixel7-pro-new"))
                list.add(Phone("Google Pixel 6 Pro",900.99,"google-pixel-6-pro"))
                list.add(Phone("Google Pixel 5 Pro",600.99,"google-pixel-5"))
            }
            PhoneCompany.SAMSUNG -> {
                list.add(Phone("Samsung Galaxy S22 Ultra 5G",1499.99,"samsung-galaxy-s22-ultra-5g"))
                list.add(Phone("Samsung Galaxy A53 5G",449.99,"samsung-galaxy-a53-5g"))
                list.add(Phone("Samsung Galaxy A13",329.99,"samsung-galaxy-a13"))
            }
            PhoneCompany.APPLE -> {
                list.add(Phone("iPhone 14 Pro Max",1549.99,"apple-iphone-14-pro-max"))
                list.add(Phone("iPhone 13 Pro Max",1399.99,"apple-iphone-13-pro-max"))
                list.add(Phone("iPhone 12 Pro Max",1029.99,"apple-iphone-12-pro-max"))
            }
        }

        return list
    }
}