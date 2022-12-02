package com.example.foodmarket.ui.order.inprogress

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodmarket.databinding.ItemInProgressBinding
import com.example.foodmarket.model.response.transaction.Data
import com.example.foodmarket.model.response.transaction.TransactionResponse
import com.example.foodmarket.utils.Helpers.formatPrice

class InProgressAdapter(
    private val listData : List<Data>,
    private val itemAdapterCallback: ItemAdapterCallback,
) : RecyclerView.Adapter<InProgressAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InProgressAdapter.ViewHolder {
        val itemInProgressBinding = ItemInProgressBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemInProgressBinding)
    }

    override fun onBindViewHolder(holder: InProgressAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position], itemAdapterCallback)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder (private val binding: ItemInProgressBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Data, itemAdapterCallback: ItemAdapterCallback) {
            itemView.apply {
                binding.tvTitle.text = data.food?.name
                binding.tvPrice.formatPrice(data.food?.price.toString())
                Glide.with(context)
                    .load(data.food?.picturePath)
                    .into(binding.imgPoster)

                itemView.setOnClickListener { itemAdapterCallback.onClick(it, data) }
            }
        }

    }

    interface ItemAdapterCallback {
        fun onClick(v: View, data: Data)
    }
}