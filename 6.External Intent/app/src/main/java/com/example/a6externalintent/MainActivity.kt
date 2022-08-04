package com.example.a6externalintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //start code for button from here
        val startActivity=findViewById<Button>(R.id.button_n)//got the button by it's id
        startActivity.setOnClickListener {
//the startactivity is a variable that acceses a lambda function setonclck of class Button
            val intent=Intent(this,HelloActivity::class.java).apply {
                putExtra("Name" ,"John")//put the vales
            }//ont of the parameter is class hello activuty
            startActivity(intent)
        }
    }
}
//first get the button
//thne on click
//then intent set
