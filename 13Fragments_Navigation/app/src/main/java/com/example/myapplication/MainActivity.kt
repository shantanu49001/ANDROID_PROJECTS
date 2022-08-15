package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment=TwoFragment()//.kt file
        val fragmentManager=supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.main_container,fragment)
        fragmentTransaction.commit()


    }
}