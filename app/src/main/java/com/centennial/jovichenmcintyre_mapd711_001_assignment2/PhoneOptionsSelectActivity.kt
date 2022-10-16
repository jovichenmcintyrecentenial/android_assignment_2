package com.centennial.jovichenmcintyre_mapd711_001_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.models.Phone
import com.google.gson.Gson

class PhoneOptionsSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_options_select)

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


        phoneNameTextView.text = selectedPhone.name
        val resourceImage: Int = resources.getIdentifier(selectedPhone.uri, "drawable", packageName)
        phoneImageView?.setImageResource(resourceImage)

    }

    fun onSelectRadioButton(view: View) {}
    fun onSubmit(view: View) {}
}