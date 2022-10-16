package com.centennial.jovichenmcintyre_mapd711_001_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.models.Phone
import com.google.gson.Gson

class PhoneOptionsSelectActivity : AppCompatActivity() {

    lateinit var selectInternalStorage:String
    lateinit var  selectColorPhone:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_options_select)

        selectInternalStorage = resources.getString(R.string._64_gb)
        selectColorPhone = resources.getStringArray(R.array.string_of_phone_colors)[0]

        var selectedPhone = Gson().fromJson(intent.getStringExtra("phone"),Phone::class.java)
        var phoneImageView = findViewById<ImageView>(R.id.phone_image)
        var phoneNameTextView = findViewById<TextView>(R.id.phone_name)

        val spinner: Spinner = findViewById(R.id.color_spinner)

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

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectColorPhone = resources.getStringArray(R.array.string_of_phone_colors)[position]
            }

        }


        phoneNameTextView.text = selectedPhone.name
        val resourceImage: Int = resources.getIdentifier(selectedPhone.uri, "drawable", packageName)
        phoneImageView?.setImageResource(resourceImage)

    }

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
//        var newIntent = Intent(this, )
    }
}