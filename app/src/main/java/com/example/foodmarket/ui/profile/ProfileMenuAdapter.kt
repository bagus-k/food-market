package com.example.foodmarket.ui.profile

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
import com.example.foodmarket.databinding.ItemMenuProfileBinding
import com.example.foodmarket.model.dummy.HomeModel
import com.example.foodmarket.model.dummy.ProfileMenuModel
import java.lang.reflect.Type
import java.text.FieldPosition

class ProfileMenuAdapter(
    private val listData : List<ProfileMenuModel>,
    private val itemAdapterCallback: ItemAdapterCallback,
) : RecyclerView.Adapter<ProfileMenuAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileMenuAdapter.ViewHolder {
        val itemMenuProfileBinding = ItemMenuProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemMenuProfileBinding)
    }

    override fun onBindViewHolder(holder: ProfileMenuAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position], itemAdapterCallback)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder (private val binding: ItemMenuProfileBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: ProfileMenuModel, itemAdapterCallback: ItemAdapterCallback) {
            itemView.apply {
                binding.tvTitle.text = data.title
                itemView.setOnClickListener { itemAdapterCallback.onClick(it, data) }
            }
        }
    }

    interface ItemAdapterCallback {
        fun onClick(v: View, data: ProfileMenuModel)
    }
}