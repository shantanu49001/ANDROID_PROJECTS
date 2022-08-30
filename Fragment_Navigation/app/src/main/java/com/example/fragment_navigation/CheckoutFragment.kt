package com.example.fragment_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_checkout.*


class CheckoutFragment : Fragment() {
//view model-----
    private lateinit var viewModel: CheckoutViewModel
    private var quantity=1
//--xx---------

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
       // val id=CheckoutFragmentArgs.fromBundle(requireArguments()).id
        //val id=CheckoutFragmentArgs.fromBundle(requireArguments()).id
        val viewModelFactory=CheckoutViewModelFactory(id,1)
        viewModel=ViewModelProvider(this,viewModelFactory).get(CheckoutViewModel::class.java)

        //changed
        viewModel.product.observe(viewLifecycleOwner,Observer{
            setData(it)

        })
        //changed
        viewModel.qty.observe(viewLifecycleOwner,Observer{
            product_quantity.text="Quantity:{it}"
        })
        //changed------xx
        //setData(viewModel.product)//changed-----xx--------
        add_quantity.setOnClickListener {
            viewModel.addQty(1)
           // product_quantity.text=viewModel.qty.toString()--->changed
        }
        reduce_quantity.setOnClickListener {
            viewModel.reduceQty(1)
           // product_quantity.text=viewModel.qty.toString()-->changed
        }
        //transformations
        viewModel.trimmedDesc.observe(viewLifecycleOwner,Observer{
            product_short_description.text=it
        })
        //----transformations
    }
    private fun setData(product: Product?){
       product?.run {
           product_quantity.text= viewModel.qty.toString()
           product_price.text=price.toString()
           product_image.setImageResource(imageId)
           checkout.setOnClickListener {
               findNavController().navigate(R.id.action_checkout_to_thanks)
           }
       }

    }
}