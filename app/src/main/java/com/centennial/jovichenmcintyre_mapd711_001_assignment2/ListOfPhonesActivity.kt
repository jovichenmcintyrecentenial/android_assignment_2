package com.centennial.jovichenmcintyre_mapd711_001_assignment2

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.enumerators.PhoneCompany
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.models.Phone
import com.google.gson.Gson
import java.util.ArrayList

class ListOfPhonesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_phones)

        var company:PhoneCompany = Gson().fromJson(intent.getStringExtra("company"), PhoneCompany::class.java)

        var listOfPhones = getPhoneList(company)

        var listView = findViewById<ListView>(R.id.list)

        var listAdaptor = PhoneListAdaptor(this, listOfPhones)

        listView.adapter = listAdaptor

    }

    private fun getPhoneList(company: PhoneCompany):List<Phone>{
        var list = ArrayList<Phone>()

        when (company) {
            PhoneCompany.OPPO -> {
                list.add(Phone(getString(R.string.oppo_reno8),756.81,"oppo-reno8-pro","Oppo"))
                list.add(Phone(getString(R.string.oppo_A77s),303.38,"oppo-a77s","Oppo"))
                list.add(Phone(getString(R.string.oppo_reno7_5G),488.25,"oppo-reno7","Oppo"))
            }
            PhoneCompany.GOOGLE -> {
                list.add(Phone(getString(R.string.google_pixel_7_pro),1179.99,"google-pixel7-pro-new","Google"))
                list.add(Phone(getString(R.string.google_pixel_6_pro),900.99,"google-pixel-6-pro","Google"))
                list.add(Phone(getString(R.string.google_pixel_5_pro),600.99,"google-pixel-5","Google"))
            }
            PhoneCompany.SAMSUNG -> {
                list.add(Phone(getString(R.string.samung_s22_ultra_5G),1499.99,"samsung-galaxy-s22-ultra-5g","Samsung"))
                list.add(Phone(getString(R.string.samung_galaxy_a53_5g),449.99,"samsung-galaxy-a53-5g","Samsung"))
                list.add(Phone(getString(R.string.samung_galaxy_a13),329.99,"samsung-galaxy-a13","Samsung"))
            }
            PhoneCompany.APPLE -> {
                list.add(Phone(getString(R.string.iphone_14_pro_max),1549.99,"apple-iphone-14-pro-max","Apple"))
                list.add(Phone(getString(R.string.iphone_13_pro_max),1399.99,"apple-iphone-13-pro-max","Apple"))
                list.add(Phone(getString(R.string.iphone_12_pro_max),1029.99,"apple-iphone-12-pro-max","Apple"))
            }
        }

        return list
    }


    class PhoneListAdaptor(context: Activity, list:List<Phone>):  BaseAdapter(){

        var context = context
        var list = list

        override fun getCount(): Int {
            return list.count()
        }

        override fun getItem(position: Int): Phone {
            return list[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var inflatedView:View? = convertView
            var phone = list[position]

            if(inflatedView == null){
                inflatedView = LayoutInflater.from(context).
                inflate(R.layout.phone_list_item, parent, false)
            }

            var priceTextView = inflatedView?.findViewById<TextView>(R.id.phone_price)
            var phoneNameTextView = inflatedView?.findViewById<TextView>(R.id.phone_name)

            phoneNameTextView?.text = phone.name
            priceTextView?.text = phone.getFormatterPrice().toString()
            return inflatedView!!
        }

    }
}