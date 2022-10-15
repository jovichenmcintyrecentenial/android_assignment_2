package com.centennial.jovichenmcintyre_mapd711_001_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.iphone -> Toast.makeText(this,"iphone was clicked",Toast.LENGTH_LONG).show()
            R.id.samsung -> Toast.makeText(this,"samsung was clicked",Toast.LENGTH_LONG).show()
            R.id.oppo -> Toast.makeText(this,"samsung was clicked",Toast.LENGTH_LONG).show()
            R.id.googlepixel -> Toast.makeText(this,"samsung was clicked",Toast.LENGTH_LONG).show()
        }

        return super.onOptionsItemSelected(item)
    }
}