package com.example.fragment_navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*

class CheckoutViewModel(id:Int,initialQuantity:Int):ViewModel() {/*
    val product:Product?= products.find { id==it.id }
    private var _qty=initialQuantity
    val qty:Int
    get() = _qty

    fun addQty(qty:Int){
        _qty+=qty
    }
    fun reduceQty(qty: Int){
        if ((_qty-qty)>0){
            _qty-=qty
        }
    }*/

    private val _qty= MutableLiveData<Int>(initialQuantity)
    val qty:LiveData<Int>
    get() =_qty

    private val _product=MutableLiveData<Product>(products.find { id==it.id })
    val product:LiveData<Product>
    get() = _product


    /*libe data transformation*/
    val trimmedDesc:LiveData<String> = Transformations.map(_product,::trimDesc)
    private fun trimDesc(product: Product):String{
        return product.longDescription.substring(0,10).toUpperCase(Locale.getDefault())
    }
    //live data transformation

    fun addQty(newQty:Int){
        _qty.value?.let {
            _qty.value=it+newQty
        }
    }
    fun reduceQty(newQty:Int){
        _qty.value?.let{
            if ((it-newQty)>1){
                _qty.value=it-newQty
            }
        }
    }
}