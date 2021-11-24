package com.example.vaelfardsapp.yourTopStrengths

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView

import com.example.vaelfardsapp.placeholder.PlaceholderContent.PlaceholderItem
import com.example.vaelfardsapp.databinding.FragmentYourTopStrengthsRecyclerviewItemBinding

class YourTopStrengthsRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<YourTopStrengthsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentYourTopStrengthsRecyclerviewItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.checkbox.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentYourTopStrengthsRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val checkbox: CheckBox = binding.checkbox

        override fun toString(): String {
            return super.toString() + " '" + checkbox.text + "'"
        }
    }

}