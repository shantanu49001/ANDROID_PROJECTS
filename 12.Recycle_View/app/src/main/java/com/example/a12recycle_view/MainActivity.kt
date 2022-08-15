package com.example.a12recycle_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val countries= arrayOf(Country("ar","Argentina","Buenous Aires",R.drawable.argentina_162229__340),

                      Country("ch","China","Beijing",R.drawable.china_162389__340),
                      Country("ger","Germany","ABC",R.drawable.germany_31017__340),
                      Country("it","Italy","ABC",R.drawable.italy_162326__340),
                      Country("jp","Japan","Tokyo",R.drawable.japan_162328__340),
                      Country("ir","Ireland","ABC",R.drawable.ireland_162323__340),
                      Country("Russ","Russia","Abc",R.drawable.russia_26896__340),
                      Country("mex", "Mexico", "XYZ", R.drawable.mexico_26989__340),
                      Country("au","Australia","Canberaa", R.drawable.australia_1296727__480),
                      Country("br","Brazil","Brasilia",R.drawable.brazil_305531__340),
                      Country("usa","USA","Washington DC",R.drawable.america_1861417__340),)



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //we will put the activity matrials that req our coding
        val countryList=findViewById<RecyclerView>(R.id.country_list).apply {
           //positions the items of recycleview
            layoutManager=LinearLayoutManager(this@MainActivity)//this is a recycler view so that it can refer t current object=whenever there is ambguity of main activit e
            adapter=CountryAdapter {
            //Toast.makeText("${it.capitalCity}".toString())
            }.apply{setHasStableIds(true)}

            setHasFixedSize(true)

        }
        val showCountries=findViewById<Button>(R.id.button)
        showCountries.setOnClickListener {
            (countryList.adapter as CountryAdapter).countryData= countries
        }
    }
}