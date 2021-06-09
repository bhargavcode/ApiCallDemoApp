package com.devbhargav.testa.category.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devbhargav.testa.category.data.CategoryDataModel
import com.devbhargav.testa.category.data.CategoryRepository

class CategoryViewModel : ViewModel() {
    private var categoryRepository:CategoryRepository?=null
    var CategoryModelListLiveData : LiveData<List<CategoryDataModel>>?=null


    init {
        categoryRepository = CategoryRepository()
        CategoryModelListLiveData = MutableLiveData()
    }

    fun getAllCategories(){
        CategoryModelListLiveData = categoryRepository?.getCategory()
    }


}