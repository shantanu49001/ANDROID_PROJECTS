package com.example.fragment_navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
//this is defualt code whenver we want to use view model just change the properties
//package com.example.viewmodelExample                         //change
class CheckoutViewModelFactory (private var id:Int,private val quantity:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CheckoutViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CheckoutViewModel(id,quantity)as T//change
        }
        throw IllegalArgumentException("unkown model class")
    }
}


