package com.example.eventhadling

import android.location.GnssAntennaInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //start code from here above this is rendered by default

        val myName:TextView=findViewById(R.id.textView)
        val showName:Button=findViewById<Button>(R.id.button)
        val listener=object:ViewOnClickListener
        {
         fun OnClick(v:View?){
             myName.text=getString(R.string.myName)
         }
        }
        showName.setOnClickListener(Listener)

            //for secnd button
        val myMessage:EditText=findViewById(R.id.Name)
        showMessage.setOnClickListener{
            it=View!
            Toast.makeText(this,myMessage.text,Toast.LENGTH_LONG).show()
        }


    }
}


