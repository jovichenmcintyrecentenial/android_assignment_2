package com.centennial.jovichenmcintyre_mapd711_001_assignment2
//Name: Jovi Chen-Mcintyre
//ID: 301125059
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.centennial.jovichenmcintyre_mapd711_001_assignment2.enumerators.PhoneCompany
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //load menu
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //create new intent to ListOfPhonesActivity
        var newIntent = Intent(this, ListOfPhonesActivity::class.java)
        var selectedCompany:PhoneCompany? = null

        when(item.itemId) {
            R.id.apple -> selectedCompany = PhoneCompany.APPLE
            R.id.samsung -> selectedCompany = PhoneCompany.SAMSUNG
            R.id.oppo -> selectedCompany = PhoneCompany.OPPO
            R.id.google -> selectedCompany = PhoneCompany.GOOGLE
        }

        if (selectedCompany != null) {
            //serialize and update intent to store company selected
            newIntent.putExtra("company", Gson().toJson(selectedCompany))
            //load intent
            startActivity(newIntent)

        }

        return super.onOptionsItemSelected(item)
    }
}