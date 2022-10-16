package com.centennial.jovichenmcintyre_mapd711_001_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.exceptions.UserInputException
import java.time.LocalDateTime
import java.util.*

class CheckOutActivity : AppCompatActivity() {

    lateinit var ccNumber: EditText
    lateinit var  cvvNumber: EditText
    lateinit var  expiryMonth: EditText
    lateinit var  expiryYear: EditText
    lateinit var  fname: EditText
    lateinit var  lname: EditText
    lateinit var  phoneNumber: EditText
    lateinit var  address: EditText
    lateinit var  city: EditText
    lateinit var  postalCode: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)
        ccNumber = findViewById(R.id.cc_number)
         cvvNumber = findViewById(R.id.cvv_number)
         expiryMonth = findViewById(R.id.expiry_month)
         expiryYear = findViewById(R.id.expiry_year)
         fname = findViewById(R.id.fname)
         lname = findViewById(R.id.lname)
         phoneNumber = findViewById(R.id.phone_number)
         address = findViewById(R.id.address)
         city = findViewById(R.id.city)
         postalCode = findViewById(R.id.postal_code)

    }

    //validate edit text information if there is an issue throw an exception
    private fun isDataValid(): Boolean {

        if(ccNumber.text.trim().isEmpty()){
            throw UserInputException("Please fill out the card number field")
        }
        else if(ccNumber.text.trim().length != 16){
            throw UserInputException("Please enter 16 digits for card number")
        }
        if(cvvNumber.text.trim().isEmpty()){
            throw UserInputException("Please fill out the cvv field")
        }
        else if(cvvNumber.text.trim().length != 3){
            throw UserInputException("Please enter 3 digits for cvv number")
        }
        if(expiryMonth.text.trim().isEmpty()){
            throw UserInputException("Please fill out the expiry month field")
        }
        else if(expiryMonth.text.toString().toDouble() > 12){
            throw UserInputException("There is only 12 months in a year")
        }
        if(expiryYear.text.trim().isEmpty()){
            throw UserInputException("Please fill out the expiry year field")
        }
        else {
            var year = Calendar.getInstance().get(Calendar.YEAR).toString()
            year = year.substring(2,year.length)
            val yearInput = expiryYear.text.toString()
            if(yearInput.toDouble() < year.toDouble()) {
                throw UserInputException("Please enter a valid year")
            }
        }
        if(fname.text.trim().isEmpty()){
            throw UserInputException("Please fill out the firstname field")
        }
        if(lname.text.trim().isEmpty()){
            throw UserInputException("Please fill out the lastname field")
        }
        if(phoneNumber.text.trim().isEmpty()){
            throw UserInputException("Please fill out the phone number field")
        }
        if(address.text.trim().isEmpty()){
            throw UserInputException("Please fill out the address field")
        }
        if(city.text.trim().isEmpty()){
            throw UserInputException("Please fill out the city field")
        }
        if(postalCode.text.trim().isEmpty()){
            throw UserInputException("Please fill out the postal code field")
        }

        return true
    }

    //use to display toast messages
    private fun showMessage(message:String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }


    fun onSubmit(view: View) {
        try{
            if(isDataValid()){

            }
        }
        //catch  and display user input exception
        catch (e: UserInputException) {
            //display exception message
            showMessage(e.message.toString())
        }
    }
}