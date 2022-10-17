package com.centennial.jovichenmcintyre_mapd711_001_assignment2
//Name: Jovi Chen-Mcintyre
//ID: 301125059
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.enumerators.PhoneCompany
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.models.Phone
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.models.PhoneCheckOut
import com.google.gson.Gson
import java.util.*

class ListOfPhonesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_phones)

        //deserialize PhoneCompany enum from intent
        var company:PhoneCompany = Gson().fromJson(intent.getStringExtra("company"), PhoneCompany::class.java)

        //get list of phone based on company
        var listOfPhones = getPhoneList(company)

        //if list not empty update action bar title to company name
        if(listOfPhones.isNotEmpty()) {
            supportActionBar?.title = listOfPhones[0].company
            //find image company image view
            val companyImageView = findViewById<ImageView>(R.id.company_logo)
            //get company image based on company name
            val resourceImage: Int = resources.getIdentifier(listOfPhones[0].company.lowercase(), "drawable", packageName)
            //display company logo
            companyImageView?.setImageResource(resourceImage)
        }
        //find list view
        var listView = findViewById<ListView>(R.id.list)

        //create instance of a custom listAdpator called PhoneListAdaptor
        var listAdaptor = PhoneListAdaptor(this, listOfPhones)

        //create a listener for on click aciton on list view
        listView.setOnItemClickListener { parent, view, position, id ->
            var newIntent = Intent(this,PhoneOptionsSelectActivity::class.java)
            //update create PhoneCheckOut and serialize data and pass to intent
            newIntent.putExtra("checkout", Gson().toJson(PhoneCheckOut(listOfPhones[position])))
            //load new Intent
            startActivity(newIntent)
        }

        //attact adaptor to listview
        listView.adapter = listAdaptor



    }

    //function to get a list of phone  based on company names
    private fun getPhoneList(company: PhoneCompany):List<Phone>{
        var list = ArrayList<Phone>()

        when (company) {
            PhoneCompany.OPPO -> {
                list.add(Phone(getString(R.string.oppo_reno8),756.81,"oppo_reno8_pro","Oppo"))
                list.add(Phone(getString(R.string.oppo_A77s),303.38,"oppo_a77s","Oppo"))
                list.add(Phone(getString(R.string.oppo_reno7_5G),488.25,"oppo_reno7","Oppo"))
            }
            PhoneCompany.GOOGLE -> {
                list.add(Phone(getString(R.string.google_pixel_7_pro),1179.99,"google_pixel7_pro_new","Google"))
                list.add(Phone(getString(R.string.google_pixel_6_pro),900.99,"google_pixel_6_pro","Google"))
                list.add(Phone(getString(R.string.google_pixel_5_pro),600.99,"google_pixel_5","Google"))
            }
            PhoneCompany.SAMSUNG -> {
                list.add(Phone(getString(R.string.samung_s22_ultra_5G),1499.99,"samsung_galaxy_s22_ultra_5g","Samsung"))
                list.add(Phone(getString(R.string.samung_galaxy_a53_5g),449.99,"samsung_galaxy_a53_5g","Samsung"))
                list.add(Phone(getString(R.string.samung_galaxy_a13),329.99,"samsung_galaxy_a13","Samsung"))
            }
            PhoneCompany.APPLE -> {
                list.add(Phone(getString(R.string.iphone_14_pro_max),1549.99,"apple_iphone_14_pro_max","Apple"))
                list.add(Phone(getString(R.string.iphone_13_pro_max),1399.99,"apple_iphone_13_pro_max","Apple"))
                list.add(Phone(getString(R.string.iphone_12_pro_max),1029.99,"apple_iphone_12_pro_max","Apple"))
            }
        }

        return list
    }


    //custom list adaptor to achieve design
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
            //load data at position
            val phone = list[position]


            if(inflatedView == null){
                //inflate custom list item layout
                inflatedView = LayoutInflater.from(context).
                inflate(R.layout.phone_list_item, parent, false)
            }

            //find views
            val priceTextView = inflatedView?.findViewById<TextView>(R.id.phone_price)
            val phoneImage = inflatedView?.findViewById<ImageView>(R.id.phone_image)
            val phoneNameTextView = inflatedView?.findViewById<TextView>(R.id.phone_name)

            //dynamically load phone images using phone uri
            val resourceImage: Int = context.resources.getIdentifier(phone.uri, "drawable", context.packageName)
            phoneImage?.setImageResource(resourceImage)

            //update phone name in list
            phoneNameTextView?.text = phone.name
            //update price on list time
            priceTextView?.text = phone.getFormatterPrice().toString()
            return inflatedView!!
        }

    }
}