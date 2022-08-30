package com.example.fragment_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var product:Product?=null
        val id=arguments?.getInt("ID")
        id?.let {
            product= products.find { it.id==id }
        }
        product?.let {
            with(it){
                //val product_name:TextView.OnEditorActionListener
                var product_name=view.findViewById<TextView>(R.id.name)
                product_name.text=name
              /*
              *
              *  product_price.text=price
                product_description.text=shortDescription
                product_full_description.text=longDescription
                product_image.setImageResource(imageId)
              *
              * */
               var product_price=view.findViewById<TextView>(R.id.product_price)
                product_price.text= price.toString()
                var product_description=view.findViewById<TextView>(R.id.description)
                product_description.text=shortDescription
                var product_full_description=view.findViewById<TextView>(R.id.full_description)
                product_full_description.text=longDescription
                var product_image=view.findViewById<ImageView>(R.id.product_image)
                product_image.setImageResource(imageId)

              val buy=view.findViewById<Button>(R.id.buy)
                buy.setOnClickListener{
                    val bundle=Bundle()
                    bundle.putInt("ID",it.id)
                    findNavController().navigate(R.id.action_detail_to_checkout,bundle)
                }
            }

        }
    }

}