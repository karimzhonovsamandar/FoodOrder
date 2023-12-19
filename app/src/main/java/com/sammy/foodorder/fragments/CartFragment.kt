package com.sammy.foodorder.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sammy.foodorder.R
import com.sammy.foodorder.adapter.CartAdapter
import com.sammy.foodorder.adapter.PopularAdapter
import com.sammy.foodorder.databinding.FragmentCartBinding
import com.sammy.foodorder.models.PopularModel


class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var list: ArrayList<PopularModel>
    private lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater,container,false)

        list = ArrayList()
        for (i in 0..5) {
            list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "$7"))
            list.add(PopularModel(R.drawable.pop_menu_sandwich, "Momo", "$9"))
            list.add(PopularModel(R.drawable.pop_menu_momo, "Burger", "$5"))
        }

        adapter = CartAdapter(requireContext(),list)
        binding.cartRv.layoutManager  = LinearLayoutManager(requireContext())
        binding.cartRv.adapter = adapter

        return binding.root
    }

}