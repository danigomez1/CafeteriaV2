package com.liem.cafeteriav2.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.liem.cafeteriav2.R
import java.util.Locale

class CustomAdapter (
    private val products: List<ProductModel>,
    private val sharedVM: SharedVM
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        val ivImage: ImageView = itemView.findViewById(R.id.productImage)
        val tvName: TextView = itemView.findViewById(R.id.productName)
        val tvPrice: TextView = itemView.findViewById(R.id.productPrice)
        val btnAdd: Button = itemView.findViewById(R.id.productButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.begudes_cardview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        holder.tvName.text = product.name

        holder.tvPrice.text = "Price: \$${product.price}"

        val imageRes = when (product.type.lowercase(Locale.getDefault())) {
            "begudes" -> R.drawable.ampolla
            "plats"   -> R.drawable.pizza
            "postres" -> R.drawable.pastis
            else      -> R.drawable.outline_no_meals_24
        }
        holder.ivImage.setImageResource(imageRes)

        holder.btnAdd.setOnClickListener {
            val newQuantity = product.quantity + 1
            val actualized  = product.copy(quantity = newQuantity)
            sharedVM.addItem(actualized)
            Toast.makeText(
                holder.itemView.context,
                "${product.name} added (qty=$newQuantity)",
                Toast.LENGTH_SHORT
            ).show()

            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = products.size
}