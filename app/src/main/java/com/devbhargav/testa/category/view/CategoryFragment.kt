package com.devbhargav.testa.category.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devbhargav.testa.category.data.CategoryDataModel
import com.devbhargav.testa.category.viewmodel.CategoryViewModel
import com.devbhargav.testa.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {
    lateinit var _binding: FragmentCategoryBinding
    private lateinit var vm: CategoryViewModel
    private lateinit var adapter: CategoryAdapter
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm = ViewModelProvider(this).get(CategoryViewModel::class.java)

        _binding = FragmentCategoryBinding.inflate(inflater, container, false)

        initAdapter()

        vm.getAllCategories()
        vm.CategoryModelListLiveData?.observe(requireActivity(), Observer {
            if (it != null) {
                binding.rvCategory.visibility = View.VISIBLE
                adapter.setData(it as ArrayList<CategoryDataModel>)
            } else {
                showToast("Unable to load category")
            }
            binding.progressBar.visibility = View.GONE
        })



        return binding.root
    }

    private fun initAdapter() {
        adapter = CategoryAdapter()
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCategory.adapter = adapter
    }

    private fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}