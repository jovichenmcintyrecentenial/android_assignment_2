package com.centennial.jovichenmcintyre_mapd711_001_assignment2
//Name: Jovi Chen-Mcintyre
//ID: 301125059
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.models.Phone
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.models.PhoneCheckOut
import com.google.gson.Gson

class PhoneOptionsSelectActivity : AppCompatActivity() {

    //declare views
    lateinit var selectInternalStorage:String
    lateinit var  selectColorPhone:String
    lateinit var  checkoutObj:PhoneCheckOut

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_options_select)
        //set title
        supportActionBar?.title = getString(R.string.customize)
        //set default internal size
        selectInternalStorage = resources.getString(R.string._64_gb)
        //set default color for phone
        selectColorPhone = resources.getStringArray(R.array.string_of_phone_colors)[0]

        //deserialize PhoneCheckOut in varible checkoutObj
        checkoutObj = Gson().fromJson(intent.getStringExtra("checkout"),PhoneCheckOut::class.java)

        //find views
        var phoneImageView = findViewById<ImageView>(R.id.phone_image)
        var phoneNameTextView = findViewById<TextView>(R.id.phone_name)
        val spinner: Spinner = findViewById(R.id.color_spinner)

        //load spinner with string array daata
        ArrayAdapter.createFromResource(
            this,
            R.array.string_of_phone_colors,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        //add click listener to save select value when user selects a color from spinner
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectColorPhone = resources.getStringArray(R.array.string_of_phone_colors)[position]
            }

        }

        //display phone name in view
        phoneNameTextView.text = checkoutObj.phone.name

        //use phone.uri from phone object to get resourceImage based on uri
        val resourceImage: Int = resources.getIdentifier(checkoutObj.phone.uri, "drawable", packageName)

        //set image from for phone
        phoneImageView?.setImageResource(resourceImage)

    }

    //handle selecting of radio button options
    fun onSelectRadioButton(view: View) {

        if(view is RadioButton){

            when(view.id){
                R.id.opt_64GB -> selectInternalStorage = getString(R.string._64_gb)
                R.id.opt_128GB -> selectInternalStorage = getString(R.string._128_gb)
                R.id.opt_256GB -> selectInternalStorage = getString(R.string._256_gb)
            }
        }

    }
    fun onSubmit(view: View) {
        //create new intent to CheckOutActivity
        var newIntent = Intent(this,CheckOutActivity::class.java )

        //update checkoutObj to store select color and internal storage size
        checkoutObj.color = selectColorPhone
        checkoutObj.internalStorageSize = selectInternalStorage
        //serialize checkoutObj and save to intent
        newIntent.putExtra("checkout",Gson().toJson(checkoutObj))
        //start intent
        startActivity(newIntent)
    }
}