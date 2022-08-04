package com.example.button_launch_url

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.wear.tiles.material.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//render logic to ths layout page

        val launchUrl=findViewById<Button>(R.id.button)
        launchUrl.setOnClickListener{
        val intent=Intent().apply {
            action=Intent.ACTION_VIEW
            data= Uri.parse("https://www.google.com")

        }
            if (intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"No activity found",Toast.LENGTH_SHORT).show()
            }
        }
    }
}