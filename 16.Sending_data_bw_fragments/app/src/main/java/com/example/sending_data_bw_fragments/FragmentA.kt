package com.example.sending_data_bw_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_a.*


class FragmentA : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    //our code
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)//activity ready hone pr render


        val model:SharedViewModel=ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        //model is sharedview model type var that is a java cass activity
        model.updateProduct(1)//shred view odel me id=2 pass ab ye product me match higa aur find krenge

        model.product.observe(viewLifecycleOwner,Observer{
            //product =one of the element of Products list

            product_name.text="Product name is"+it.name//contatination
            //it is the text view in product name
        })


    }
}