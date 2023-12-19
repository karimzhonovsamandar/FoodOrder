package com.sammy.foodorder.fragments

import android.graphics.ColorSpace.Model
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.sammy.foodorder.R
import com.sammy.foodorder.adapter.PopularAdapter
import com.sammy.foodorder.databinding.FragmentSearchBinding
import com.sammy.foodorder.models.PopularModel
import java.lang.reflect.Array

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var list : ArrayList<PopularModel>
    private lateinit var adapter: PopularAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        list = ArrayList()
        for (i in 0..5) {
            list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "$7"))
            list.add(PopularModel(R.drawable.pop_menu_sandwich, "Momo", "$9"))
            list.add(PopularModel(R.drawable.pop_menu_momo, "Burger", "$5"))
        }

        adapter = PopularAdapter(requireContext(),list)
        binding.searchMenuRv.layoutManager  = LinearLayoutManager(requireContext())
        binding.searchMenuRv.adapter = adapter


        searchMenuFood()
        return binding.root

        }

    private fun searchMenuFood() {
        binding.searchViewItem.setOnQueryTextListener(object : OnQueryTextListener,
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filteredList(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filteredList(newText)
                return true
            }

        })
    }


    private fun filteredList(input:String?){
        val filteredList = if (input.isNullOrEmpty()){
            list
        }else{
            list.filter{item ->
                item.getFoodName().contains(input,ignoreCase = true)
            }
        }

        adapter.updateList(filteredList as ArrayList<PopularModel>)

    }

}