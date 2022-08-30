package com.example.sending_data_bw_fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {//returns viewModel that is shared
    private val _product= MutableLiveData<Product>()//_product has Product list that is liveData
    val product:LiveData<Product>//product has onle element of list shared from live data
    get() = _product//getting that one of the product from list

    fun updateProduct(id:Int){
        _product.value= products.find {
            id==it.id
        }
    }


}
