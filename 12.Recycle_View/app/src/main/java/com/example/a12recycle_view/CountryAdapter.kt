package com.example.a12recycle_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter:RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    var countryData= arrayOf<Country>()
    set(value) {//cutomise the setter
        field=value
        notifyDataSetChanged()
    }
                           //view=inflated layout of recycler view
    class CountryViewHolder(view: View):RecyclerView.ViewHolder(view){
        val countryFlag:ImageView=view.findViewById(R.id.country_flag)
         val countryName:TextView=view.findViewById(R.id.country_name)
         val countryCity:TextView=view.findViewById(R.id.country_capital)
    }

    override fun getItemCount()=countryData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
    //intial view depending on screen size
        //called when we are ceating the new view
        val itemLayout=LayoutInflater.from(parent.context).inflate(R.layout.country_item,parent,false)
        return CountryViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
//when it is scrolled the view is not created bu the data is changed
        with(holder){
            countryFlag.setImageResource(countryData[position].flagId)
            countryName.text=countryData[position].name
            countryCity.text=countryData[position].capitalCity
        }

    }


    override fun getItemId(position: Int): Long {
        return countryData[position].code.hashCode().toLong()
    }
}