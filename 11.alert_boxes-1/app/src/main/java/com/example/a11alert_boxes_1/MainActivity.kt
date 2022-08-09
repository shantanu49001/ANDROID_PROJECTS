package com.example.a11alert_boxes_1

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.custom_list_view.CityAdapter
import com.google.gson.Gson

const val CITY_KEY="CITY_KEY"
class MainActivity : AppCompatActivity() {
  val cityData= mutableListOf<City>()//change ho sakti hai
    lateinit var cityAdapter: CityAdapter
    /* this code for setting the contents to render on the main activity and reserve the view for it */
     override fun onCreate(savedInstaceState:Bundle?){
        super.onCreate(savedInstaceState)
        setContentView(R.layout.activity_main)
    /*till here*/

        /*this function to reset the list*/
      val reset:Button=findViewById(R.id.reset_list)
        reset.setOnClickListener {
            resetList()
        }
      val add:Button=findViewById(R.id.add_city)
        add.setOnClickListener {
            addCity()
        }
        loadCities()//all these function and data to display the content in the activity main is inside the oveerride
        val cities:ListView=findViewById(R.id.cities)
        cityAdapter= CityAdapter(cityData)
        cities.adapter=cityAdapter
    }
    /*define all the functions now of the parent class*/
    private fun loadCities(){
        val sharedPref=getPreferences(Context.MODE_PRIVATE)//to store the data if app minimised
        val cities=sharedPref.getStringSet(CITY_KEY,null)
        val gson=Gson()
        cities?.forEach{
            cityData.add(gson.fromJson(it,City::class.java))
        }
        cityData.sortBy { it.name }
    }

    private fun addCity(){
        val builder=AlertDialog.Builder(this)//we want to add from the builder alert dailog box
        val inflater=this.layoutInflater//we will be inflating the loist view
        val dialogView:View=inflater.inflate(R.layout.city_add,null)//load the dailog view from city add button
        val countryName=dialogView.findViewById<EditText>(R.id.country_name)
        val cityName=dialogView.findViewById<EditText>(R.id.city_country)
        with(builder){
            setView(dialogView)
            setTitle("Add City")
            setPositiveButton("Add",object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface, id: Int) {
                    val country=countryName.text.toString()
                    val city=cityName.text.toString()
                    if (country.isNotBlank()&&city.isNotBlank()){
                        cityData.add(City(country,city))
                        cityData.sortBy { it.name }
                        saveCities()
                    }

                }
            })
          setNegativeButton("Cancel",object :DialogInterface.OnClickListener{
              override fun onClick(dialog: DialogInterface?, which: Int) {

              }
          })
        }
        val alertDialog=builder.create()
        alertDialog.show()
    }
     private fun saveCities(){
         val gson=Gson()
         val cities=cityData.map { gson.toJson(it) }
         val sharedPref=getPreferences(Context.MODE_PRIVATE)
         with(sharedPref.edit()){
             putString(CITY_KEY, cities.toSet().toString())
             commit()
         }
         cityAdapter.notifyDataSetChanged()
     }
    private fun resetList(){
        val builder=AlertDialog.Builder(this)
        with(builder){
            setTitle(getString(R.string.confirm_reset))
            setMessage(getString(R.string.confirm_reset_message))
            setPositiveButton(getString(R.string.yes),object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    cityData.clear()
                    saveCities()

                }
            })
            setNegativeButton(getString(R.string.no),object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }
            })
        }
        val alertDialog=builder.create()
        alertDialog.show() } }
