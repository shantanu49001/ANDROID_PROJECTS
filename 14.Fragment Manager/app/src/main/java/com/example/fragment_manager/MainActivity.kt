package com.example.fragment_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //3 programmable buttons to reload a fragment and a frgmnet view
        val addFragment: Button =findViewById<Button>(R.id.add_fragment)
        addFragment.setOnClickListener {
            val fragment=OneFragment()
            val fragmentTransaction=supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.main_container,fragment,"OneFragment")
            fragmentTransaction.commit()
        }

        val removeFragment=findViewById<Button>(R.id.remove_fragment)
        removeFragment.setOnClickListener {
            val fragment=supportFragmentManager.findFragmentById(R.id.main_container)
            fragment?.let {
                supportFragmentManager.beginTransaction().remove(fragment).commit()
            }
        }

        val replaceFragment=findViewById<Button>(R.id.replace_fragment)
        replaceFragment.setOnClickListener {
            val fragment=TwoFragment()
            with(supportFragmentManager.beginTransaction()){
                replace(R.id.main_container,fragment)
                addToBackStack(null)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }

        }
    }


}