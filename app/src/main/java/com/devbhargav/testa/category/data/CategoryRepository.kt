package com.devbhargav.testa.category.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devbhargav.testa.network.ApiClient
import com.devbhargav.testa.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRepository {
    val data = MutableLiveData<List<CategoryDataModel>>()
    private var apiInterface:ApiInterface?=null

    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    }

    fun getCategory(): LiveData<List<CategoryDataModel>> {
        apiInterface?.getAllCategories()?.enqueue(object : Callback<List<CategoryDataModel>> {

            override fun onFailure(call: Call<List<CategoryDataModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<CategoryDataModel>>,
                response: Response<List<CategoryDataModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }
            }
        })
        return data
    }
}