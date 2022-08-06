package com.example.a9list_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//set the activity pallet where we eant to show

        //list content-----------------------------------------
        val cityNames = arrayOf("New Delhi", "New York", "Paris", "Rome", "Amsterdam")
        val cities: ListView = findViewById(R.id.cities)

        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cityNames)//impor for array adpter type vr

        cities.adapter = cityAdapter

        cities.setOnItemClickListener{ adapterView, view, position, id ->

            val city: TextView = view as TextView
            Toast.makeText(this, city.text, Toast.LENGTH_SHORT).show()
        }
    }
}
