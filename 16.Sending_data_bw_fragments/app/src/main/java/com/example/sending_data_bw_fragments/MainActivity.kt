package com.example.sending_data_bw_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


val products= mutableListOf<Product>(Product(1, "Pixel", 45000F, "meet the speed",))

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


      //  val show:Button=findViewById(R.id.show_fragmentb)
        show_fragmentb.setOnClickListener {
            val fragment=FragmentB()//constructr of fragment B class that returns a fragmnet and isstored in a variable
            val fragmentTransaction=supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.main_container,fragment,"Fragment shown by transaction methid in main container view and fragment variable hilds fragment b this")
            fragmentTransaction.commit()
        }
    }
}