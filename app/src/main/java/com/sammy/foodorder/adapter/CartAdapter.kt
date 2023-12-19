package com.sammy.foodorder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sammy.foodorder.databinding.CartAddItemBinding
import com.sammy.foodorder.databinding.HomeFoodItemBinding
import com.sammy.foodorder.models.PopularModel

class CartAdapter(
    val context: Context,
    val list: ArrayList<PopularModel>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.CartViewHolder {
        val binding = CartAddItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CartViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CartAdapter.CartViewHolder, position: Int) {

        val listModel = list[position]

        holder.foodName.text = listModel.getFoodName()
        holder.foodPrice.text = listModel.getFoodPrice()
        listModel.getFoodImage()?.let { holder.foodImage.setImageResource(it) }

        holder.plus.setOnClickListener {

        }

        holder.minus.setOnClickListener {

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class CartViewHolder(binding: CartAddItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val foodName = binding.homeFoodName
        val foodImage = binding.homeFoodImage
        val foodPrice = binding.priceBtn

        val plus = binding.plusBtn
        val minus = binding.minusBtn

        fun bindItem(){
            if (adapterPosition != RecyclerView.NO_POSITION){
                deleteItem(adapterPosition)
            }
        }

    }



    fun deleteItem(position: Int){
        for(position in 0..list.size){
            list.removeAt(position)
            notifyDataSetChanged()
            notifyItemChanged(position,list.size)

        }
    }

}