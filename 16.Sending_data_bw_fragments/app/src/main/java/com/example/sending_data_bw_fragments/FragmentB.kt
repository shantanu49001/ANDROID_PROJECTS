package com.example.sending_data_bw_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_a.*


class FragmentB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

//companion objecy intro var and oncreate remove

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
                                                   //of ko remove krke
        val model:SharedViewModel=ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        model.product.observe(viewLifecycleOwner, Observer {
            product_name.text="Product name is"+it.name
        })
    }
}
//both a and b fragment have a common activity as view model provider so data is shared bwtween the two