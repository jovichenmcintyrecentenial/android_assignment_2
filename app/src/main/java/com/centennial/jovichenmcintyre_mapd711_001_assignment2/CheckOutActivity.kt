package com.centennial.jovichenmcintyre_mapd711_001_assignment2
//Name: Jovi Chen-Mcintyre
//ID: 301125059
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.enumerators.CardType
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.exceptions.UserInputException
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.models.PhoneCheckOut
import com.google.gson.Gson
import java.time.LocalDateTime
import java.util.*

class CheckOutActivity : AppCompatActivity() {

    private lateinit var ccNumber: EditText
    private lateinit var  cvvNumber: EditText
    private lateinit var  expiryMonth: EditText
    private lateinit var  expiryYear: EditText
    private lateinit var  fname: EditText
    private lateinit var  lname: EditText
    private lateinit var  phoneNumber: EditText
    private lateinit var  address: EditText
    private lateinit var  city: EditText
    private lateinit var  postalCode: EditText
    var cardType: CardType? = CardType.CREDIT


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)
        //find views
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

        //update title
        supportActionBar?.title = getString(R.string.checkout)




    }

    //validate edit text information if there is an issue throw an exception
    private fun isDataValid(): Boolean {

        if(ccNumber.text.trim().isEmpty()){
            throw UserInputException(getString(R.string.empty_card_number))
        }
        else if(ccNumber.text.trim().length != 16){
            throw UserInputException(getString(R.string.error_16_digits))
        }
        if(cvvNumber.text.trim().isEmpty()){
            throw UserInputException(getString(R.string.empty_cvv))
        }
        else if(cvvNumber.text.trim().length != 3){
            throw UserInputException(getString(R.string.error_3_digit_cvv))
        }
        if(expiryMonth.text.trim().isEmpty()) {
            throw UserInputException(getString(R.string.empty_exp_month))
        }
        //check if user enter 13th or more month
        else if(expiryMonth.text.toString().toDouble() > 12){
            throw UserInputException(getString(R.string.error_12_month_in_year))
        }
        if(expiryYear.text.trim().isEmpty()){
            throw UserInputException(getString(R.string.empty_exp_year))
        }
        else {
            //check if year enter has passed
            var year = Calendar.getInstance().get(Calendar.YEAR).toString()
            year = year.substring(2,year.length)
            val yearInput = expiryYear.text.toString()
            if(yearInput.toDouble() < year.toDouble()) {
                throw UserInputException(getString(R.string.error_invaid_year))
            }
        }
        if(fname.text.trim().isEmpty()){
            throw UserInputException(getString(R.string.empty_fname))
        }
        if(lname.text.trim().isEmpty()){
            throw UserInputException(getString(R.string.empty_lname))
        }
        if(phoneNumber.text.trim().isEmpty()){
            throw UserInputException(getString(R.string.empty_number))
        }
        if(address.text.trim().isEmpty()){
            throw UserInputException(getString(R.string.empty_address))
        }
        if(city.text.trim().isEmpty()){
            throw UserInputException(getString(R.string.empty_city))
        }
        if(postalCode.text.trim().isEmpty()){
            throw UserInputException(getString(R.string.empty_postal_code))
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
                //get checkout object from intent and update data on object
                var checkoutObj = Gson().fromJson(intent.getStringExtra("checkout"),PhoneCheckOut::class.java)
                checkoutObj.cardNumber = ccNumber.text.toString()
                checkoutObj.cvv = cvvNumber.text.toString()
                checkoutObj.expirationMonth = expiryMonth.text.toString()
                checkoutObj.expirationYear = expiryYear.text.toString()
                checkoutObj.firstName = fname.text.toString()
                checkoutObj.lastName = lname.text.toString()
                checkoutObj.telephone = phoneNumber.text.toString()
                checkoutObj.address = address.text.toString()
                checkoutObj.city = city.text.toString()
                checkoutObj.postalCode = postalCode.text.toString()
                checkoutObj.cardType = cardType



                val newIntent = Intent(this,ConfirmationCheckOutActivity::class.java)
                //serial checkout object save to intent
                newIntent.putExtra("checkout" , Gson().toJson(checkoutObj))
                startActivity(newIntent)

            }
        }
        //catch  and display user input exception
        catch (e: UserInputException) {
            //display exception message
            showMessage(e.message.toString())
        }
    }

    fun onSelectRadioButton(view: View) {

        if(view is RadioButton){
            when(view.id){
                R.id.credit->cardType = CardType.CREDIT
                R.id.debit -> cardType = CardType.DEBIT
            }
        }

    }
}