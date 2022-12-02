package com.example.foodmarket.ui.order.pastorders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodmarket.databinding.ItemInProgressBinding
import com.example.foodmarket.databinding.ItemPastOrdersBinding
import com.example.foodmarket.model.response.transaction.Data
import com.example.foodmarket.model.response.transaction.TransactionResponse
import com.example.foodmarket.utils.Helpers.convertLongToTime
import com.example.foodmarket.utils.Helpers.formatPrice

class PastOrdersAdapter(
    private val listData : List<Data>,
    private val itemAdapterCallback: ItemAdapterCallback,
) : RecyclerView.Adapter<PastOrdersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastOrdersAdapter.ViewHolder {
        val itemPastOrdersBinding = ItemPastOrdersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemPastOrdersBinding)
    }

    override fun onBindViewHolder(holder: PastOrdersAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position], itemAdapterCallback)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder (private val binding: ItemPastOrdersBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Data, itemAdapterCallback: ItemAdapterCallback) {
            itemView.apply {
                binding.tvTitle.text = data.food?.name
                binding.tvPrice.formatPrice(data.food?.price.toString())
//                binding.tvDate.text = data.food?.createdAt?.toLong()?.convertLongToTime("MMM dd , HH.mm")
                Glide.with(context)
                    .load(data.food?.picturePath)
                    .into(binding.imgPoster)

                if (data.status.equals("CANCELLED", true)) {
                    binding.tvCancel.visibility = View.VISIBLE
                }

                itemView.setOnClickListener { itemAdapterCallback.onClick(it, data) }
            }
        }

    }

    interface ItemAdapterCallback {
        fun onClick(v: View, data: Data)
    }
}