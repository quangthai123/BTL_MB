package com.example.nhom19_mobile_foodordering.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nhom19_mobile_foodordering.R
import com.example.nhom19_mobile_foodordering.adapter.MenuAdapter
import com.example.nhom19_mobile_foodordering.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter : MenuAdapter
    private val originalMenuFoodName = listOf("Kem vally", "Canh Trường Thọ", "Mỳ xanh", "Bánh Herbal", "Xà lách trộn", "Tokbokki", "Canh Trường Thọ", "Mỳ xanh", "Bánh Herbal", "Xà lách trộn", "Tokbokki")
    private val originalMenuItemPrice = listOf("32.000đ", "188.000đ", "45.000đ", "102.000đ", "91.000đ", "78.000đ",  "45.000đ", "102.000đ", "32.000đ", "188.000đ", "45.000đ")
    private val originalMenuImage = listOf(
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu2,
        R.drawable.menu1,
        R.drawable.menu6,
        R.drawable.menu5,
        R.drawable.menu4,
        R.drawable.menu2,
        R.drawable.menu1,
        R.drawable.menu6,
        R.drawable.menu3
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage= mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage)

        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        setupSearchView()
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        originalMenuFoodName.forEachIndexed { index, foodName ->
            if(foodName.contains(query, ignoreCase = true)) {
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(originalMenuItemPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }


    companion object {

    }
}