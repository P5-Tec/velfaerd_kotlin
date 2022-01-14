package com.example.vaelfardsapp.yourTopStrengths

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.vaelfardsapp.databinding.FragmentYourTopStrengthsRecyclerviewItemBinding
import com.example.vaelfardsapp.models.QuestionModel
import com.example.vaelfardsapp.viewmodels.YourTopStrengthsViewModel

class YourTopStrengthsRecyclerViewAdapter(
    private val values: List<QuestionModel>,
    private val viewModel: YourTopStrengthsViewModel
) : RecyclerView.Adapter<YourTopStrengthsRecyclerViewAdapter.ViewHolder>() {

    private var count = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentYourTopStrengthsRecyclerviewItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.checkbox.text = item.styrkeName

        if (viewModel.getIs2Selected()) {
            if (!holder.checkbox.isChecked) {
                holder.checkbox.isEnabled = false
            }
        } else {
            holder.checkbox.isEnabled = true
        }

        holder.checkbox.setOnClickListener {

            if (holder.checkbox.isChecked) {
                count++
            } else {
                count--
            }

            if (count >= 2) {
                viewModel.setIs2Selected(true)
                notifyDataSetChanged()
            } else {
                viewModel.setIs2Selected(false)
                notifyDataSetChanged()
            }
        }
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