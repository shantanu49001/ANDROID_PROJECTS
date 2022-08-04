package com.example.a6externalintent

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HelloActivity : AppCompatActivity() {
    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        //first get the guestname string
        val guestName:String?=intent.getStringExtra("Name")//nullable as the string may be emtpy also
        guestName?.let {
          //labdba functio  ka one and only arg is string
            val name=findViewById<TextView>(R.id.text)//get the text holdre
            name.text=getString(R.string.guest_name,it)
        }
    }
}