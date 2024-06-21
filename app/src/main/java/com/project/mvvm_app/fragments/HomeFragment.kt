package com.project.mvvm_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.mvvm_app.adapters.CategoriesAdapter
import com.project.mvvm_app.databinding.FragmentHomeBinding
import com.project.mvvm_app.viewModels.CategoriesViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: CategoriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchCategories()

        viewModel.categories.observe(
            viewLifecycleOwner
        ) { categories ->
            binding.mealsCategoryRecyclerView.layoutManager =
                GridLayoutManager(view.context, 2, RecyclerView.HORIZONTAL, false)
            binding.mealsCategoryRecyclerView.adapter = CategoriesAdapter(categories) {
            }
        }
    }

}