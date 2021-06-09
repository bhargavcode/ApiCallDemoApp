package com.devbhargav.testa.network

import com.devbhargav.testa.category.data.CategoryDataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("categories")
    fun getAllCategories(): Call<List<CategoryDataModel>>
}