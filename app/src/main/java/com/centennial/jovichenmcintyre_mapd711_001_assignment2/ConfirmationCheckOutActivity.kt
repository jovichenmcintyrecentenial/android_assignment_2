package com.centennial.jovichenmcintyre_mapd711_001_assignment2
//Name: Jovi Chen-Mcintyre
//ID: 301125059
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.models.PhoneCheckOut
import com.google.gson.Gson

class ConfirmationCheckOutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_check_out)

        //update title
        supportActionBar?.title = getString(R.string.order_summary)

        //find and store views
        val phoneImage = findViewById<ImageView>(R.id.phone_image)
        val companyName = findViewById<TextView>(R.id.company)
        val modelName = findViewById<TextView>(R.id.model)
        val phoneColor = findViewById<TextView>(R.id.phone_color)
        val internalStorage = findViewById<TextView>(R.id.internal_storage)
        val cardType = findViewById<TextView>(R.id.card_type)
        val last4Digits = findViewById<TextView>(R.id.last_4_digits)
        val price = findViewById<TextView>(R.id.price)
        
        val userName = findViewById<TextView>(R.id.user_name)
        val address = findViewById<TextView>(R.id.address)
        val city = findViewById<TextView>(R.id.city)
        val postalCode = findViewById<TextView>(R.id.postal_code)

        //deserialize data from intent
        val checkoutObj = Gson().fromJson(intent.getStringExtra("checkout"),PhoneCheckOut::class.java)

        //display phone image
        val resourceImage: Int = resources.getIdentifier(checkoutObj.phone.uri, "drawable", packageName)
        phoneImage?.setImageResource(resourceImage)

        //populate views
        companyName.text = checkoutObj.phone.company
        modelName.text = checkoutObj.phone.name
        phoneColor.text = checkoutObj.color
        internalStorage.text = checkoutObj.internalStorageSize
        cardType.text = checkoutObj.cardType.toString()
        //show last 4 digits
        last4Digits.text = checkoutObj.cardNumber?.substring(12)
        price.text = checkoutObj.phone.getFormatterPrice()
        //populate views
        userName.text = checkoutObj.firstName+" "+checkoutObj.lastName
        address.text = checkoutObj.address
        city.text = checkoutObj.city
        postalCode.text = checkoutObj.postalCode
        
    }
}