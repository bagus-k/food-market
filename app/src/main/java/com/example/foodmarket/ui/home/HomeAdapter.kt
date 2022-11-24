package com.example.foodmarket.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SortedListAdapterCallback
import com.bumptech.glide.Glide
import com.example.foodmarket.R
import com.example.foodmarket.databinding.ItemHomeHorizontalBinding
import com.example.foodmarket.model.dummy.HomeModel
import java.lang.reflect.Type
import java.text.FieldPosition

class HomeAdapter(
    private val listData : List<HomeModel>,
    private val itemAdapterCallback: ItemAdapterCallback,
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val itemHomeHorizontalBinding = ItemHomeHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemHomeHorizontalBinding)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position], itemAdapterCallback)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder (private val binding: ItemHomeHorizontalBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: HomeModel, itemAdapterCallback: ItemAdapterCallback) {
            itemView.apply {
                binding.tvTitle.text = data.title
                binding.tvRatingBar.rating = data.rating
//                Glide.with(context)
//                    .load(data.src)
//                    .into(binding.imgPoster)

                itemView.setOnClickListener { itemAdapterCallback.onClick(it, data) }
            }
        }

    }

    interface ItemAdapterCallback {
        fun onClick(v: View, data: HomeModel)
    }
}