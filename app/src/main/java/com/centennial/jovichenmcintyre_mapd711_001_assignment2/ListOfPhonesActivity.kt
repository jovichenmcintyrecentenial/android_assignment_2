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
                list.add(Phone(getString(R.string.oppo_reno8),756.81,"oppo-reno8-pro"))
                list.add(Phone(getString(R.string.oppo_A77s),303.38,"oppo-a77s"))
                list.add(Phone(getString(R.string.oppo_reno7_5G),488.25,"oppo-reno7"))
            }
            PhoneCompany.GOOGLE -> {
                list.add(Phone(getString(R.string.google_pixel_7_pro),1179.99,"google-pixel7-pro-new"))
                list.add(Phone(getString(R.string.google_pixel_6_pro),900.99,"google-pixel-6-pro"))
                list.add(Phone(getString(R.string.google_pixel_5_pro),600.99,"google-pixel-5"))
            }
            PhoneCompany.SAMSUNG -> {
                list.add(Phone(getString(R.string.samung_s22_ultra_5G),1499.99,"samsung-galaxy-s22-ultra-5g"))
                list.add(Phone(getString(R.string.samung_galaxy_a53_5g),449.99,"samsung-galaxy-a53-5g"))
                list.add(Phone(getString(R.string.samung_galaxy_a13),329.99,"samsung-galaxy-a13"))
            }
            PhoneCompany.APPLE -> {
                list.add(Phone(getString(R.string.iphone_14_pro_max),1549.99,"apple-iphone-14-pro-max"))
                list.add(Phone(getString(R.string.iphone_13_pro_max),1399.99,"apple-iphone-13-pro-max"))
                list.add(Phone(getString(R.string.iphone_12_pro_max),1029.99,"apple-iphone-12-pro-max"))
            }
        }

        return list
    }
}