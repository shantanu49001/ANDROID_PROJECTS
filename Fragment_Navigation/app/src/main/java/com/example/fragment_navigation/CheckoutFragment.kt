package com.example.fragment_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.FIND_VIEWS_WITH_TEXT
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_detail.*


class CheckoutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var product:Product?=null
        val id=arguments?.getInt("ID")
        id?.let {
            product= products.find { it.id==id }
        }
        product?.let {
            with(it){

                //fragments me view.find.....
                var product_price=view.findViewById<TextView>(R.id.price)
                product_price.text=name
                var product_description=view.findViewById<TextView>(R.id.description)
                product_description.text=shortDescription
                var product_full_description=view.findViewById<TextView>(R.id.full_description)
                product_full_description.text=longDescription
                var product_image=view.findViewById<ImageView>(R.id.image)
                product_image.setImageResource(imageId)

                buy.setOnClickListener{
                    val bundle=Bundle()
                    bundle.putInt("ID",it.id)
                    findNavController().navigate(R.id.action_checkout_to_thanks,bundle)//moving to the next activity
                }
            }

        }
    }
}