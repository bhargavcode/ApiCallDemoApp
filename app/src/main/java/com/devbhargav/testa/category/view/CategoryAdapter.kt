package com.devbhargav.testa.category.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devbhargav.testa.category.data.CategoryDataModel
import com.devbhargav.testa.databinding.CategoryItemLayoutBinding

class CategoryAdapter() : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var data: ArrayList<CategoryDataModel>? = null


    fun setData(list: ArrayList<CategoryDataModel>) {
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            CategoryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = data?.get(position)
        holder.idView.setText("ID : "+item!!.id.toString())
        holder.nameView.setText("Name : "+item!!.name)
    }

    fun addData(dataModel: CategoryDataModel) {
        data?.add(0, dataModel)
        notifyItemInserted(0)
    }

    fun removeData(position: Int) {
        data?.removeAt(position)
        notifyDataSetChanged()
    }

    class CategoryViewHolder(itemView: CategoryItemLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val idView: TextView = itemView.catId
        val nameView: TextView = itemView.catName
    }

}