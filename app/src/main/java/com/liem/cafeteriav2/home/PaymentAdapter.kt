package com.liem.cafeteriav2.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liem.cafeteriav2.R

class PaymentAdapter (
    private val items: List<ProductModel>
) : RecyclerView.Adapter<PaymentAdapter.PMViewHolder>() {
    class PMViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvProductName)
        val tvQty: TextView = view.findViewById(R.id.tvQuantity)
        val tvSubtotal: TextView = view.findViewById(R.id.tvSubtotal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PMViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pagament_cardview, parent, false)
        return PMViewHolder(view)
    }

    override fun onBindViewHolder(holder: PMViewHolder, position: Int) {
        val product = items[position]
        holder.tvName.text = product.name
        holder.tvQty.text = "x${product.quantity}"

        val unitPrice = product.price.toDoubleOrNull() ?: 0.0
        val subtotal   = unitPrice * product.quantity
        holder.tvSubtotal.text = String.format("$%.2f", subtotal)
    }

    override fun getItemCount(): Int = items.size
}