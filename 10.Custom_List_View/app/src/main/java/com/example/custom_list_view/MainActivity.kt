package com.example.custom_list_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cityData= arrayOf(City("India","New Delhi"),
                             City("USA","New York"),
                             City("France","Paris"),
                             City("Italy","Rome"),
                             City("Netherlands","Amsterdam")

        )

        val cities:ListView=findViewById(R.id.cities)
        val cityAdapter=CityAdapter(cityData)

        cities.adapter=cityAdapter//iske baad printing age wali file me adapter k through hoga
    }
}