package com.example.nhom19_mobile_foodordering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nhom19_mobile_foodordering.databinding.BuyAgainItemBinding

class BuyAgainAdapter(
    private val buyAgainFoodName:ArrayList<String>,
    private val buyAgainFoodPrice:ArrayList<String>,
    private val buyAgainFoodImage:ArrayList<Int>
) : RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(buyAgainFoodName[position], buyAgainFoodPrice[position], buyAgainFoodImage[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuyAgainViewHolder(binding)
    }


    override fun getItemCount(): Int = buyAgainFoodName.size

    class BuyAgainViewHolder(private val binding:BuyAgainItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: String, s1: String, i: Int) {
            binding.buyAgainFoodName.text = s
            binding.buyAgainFoodPrice.text = s1
            binding.buyAgainFoodImage.setImageResource(i)
        }

    }
}