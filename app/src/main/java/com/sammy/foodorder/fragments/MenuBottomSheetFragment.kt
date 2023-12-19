package com.sammy.foodorder.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sammy.foodorder.R
import com.sammy.foodorder.adapter.PopularAdapter
import com.sammy.foodorder.models.PopularModel


class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var adapter: PopularAdapter
    private lateinit var menuList: ArrayList<PopularModel>
    private lateinit var menuRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_menu_bottom_sheet, container, false)

        menuList = ArrayList()
        for (i in 0..5) {
            menuList.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich", "$7"))
            menuList.add(PopularModel(R.drawable.pop_menu_sandwich, "Momo", "$9"))
            menuList.add(PopularModel(R.drawable.pop_menu_momo, "Burger", "$5"))
        }

        adapter = PopularAdapter(requireContext(),menuList)

        menuRv = view.findViewById(R.id.menu_RV)
        menuRv.layoutManager = LinearLayoutManager(requireContext())
        menuRv.adapter = adapter

        return view
    }

}