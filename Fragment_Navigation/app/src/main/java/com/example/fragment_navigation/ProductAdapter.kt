package com.example.fragment_navigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

class ProductAdapter(private val listener: (Product) -> Unit) : ListAdapter <Product,ProductAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val itemLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        init {
            itemView.setOnClickListener {
                listener.invoke(getItem(adapterPosition))
            }
        }

        fun bind(countryData: Product) {
            with(countryData) {
                var product_name=containerView.findViewById<TextView>(R.id.name)
                product_name.text = name
                var product_image=containerView.findViewById<ImageView>(R.id.product_image)
                product_image.setImageResource(imageId)
                var product_price=containerView.findViewById<TextView>(R.id.product_price)
                product_price.text = "Price is {price}"
                var product_description=containerView.findViewById<TextView>(R.id.description)
                product_description.text=shortDescription
            }
        }
    }
}
    class DiffCallback:DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.imageId==newItem.imageId
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem==newItem
        }
    }

