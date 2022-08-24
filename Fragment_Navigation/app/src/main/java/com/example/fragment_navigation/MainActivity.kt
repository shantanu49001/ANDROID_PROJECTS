package com.example.fragment_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//outside data

val products= mutableListOf<Product>(Product(1,"Samsung A30",45000F,R.drawable.app_1,
"Meet A30.Premium for less","Save your memories with high Quality and unlimited Storage "),
Product(2,"OPPO A54",33000F,R.drawable.app_2,"","Cheap with all features fits to pocket"),
Product(3,"Jio Phone",5000F,R.drawable.app_3,"Small And Compact","Cheap with all features fits to pocket"),
Product(4,"Pixel 3A",50000F,R.drawable.app_4,"Meet A30.Premium for less","Save your memories with high Quality and unlimited Storage"))




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}