package com.onnet.databinding

import com.onnet.databinding.pojo.SingleDataItem
import com.onnet.databinding.ListAdapter.ItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.onnet.databinding.ListAdapter.CustomViewHolder
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import com.onnet.databinding.R
import com.onnet.databinding.databinding.ListItemBinding

class ListAdapter(var mDatalist: List<SingleDataItem>?, var mListener: ItemClickListener) :
    RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = DataBindingUtil.inflate<ListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item,
            parent,
            false
        )
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(mDatalist!![position], mListener)
    }

    override fun getItemCount(): Int {
        return if (mDatalist == null) 0 else mDatalist!!.size
    }

    class CustomViewHolder(var binding: ListItemBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(item: SingleDataItem, itemClickListener: ItemClickListener?) {
            item.landscapeImage = "https://pngimg.com/uploads/android_logo/android_logo_PNG27.png"
            binding.data = item
            binding.itemClickListener = itemClickListener
            binding.executePendingBindings()
        }
    }

    interface ItemClickListener {
        fun onItemClicked(item: SingleDataItem?)
    }
}