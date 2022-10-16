package com.centennial.jovichenmcintyre_mapd711_001_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class CheckOutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        var ccNumber = findViewById<EditText>(R.id.cc_number)
    }

    fun onSubmit(view: View) {}
}