package com.example.vaelfardsapp.yourTopStrengths

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.vaelfardsapp.databinding.FragmentYourTopStrengthsRecyclerviewItemBinding
import com.example.vaelfardsapp.models.questionModel
import com.example.vaelfardsapp.viewmodels.YourTopStrengthsViewModel

class YourTopStrengthsRecyclerViewAdapter(
    private val values: List<questionModel>,
    private val viewModels: YourTopStrengthsViewModel
) : RecyclerView.Adapter<YourTopStrengthsRecyclerViewAdapter.ViewHolder>() {

    private var count = 0
    private var is2Selected = false
//    private val viewModel: YourTopStrengthsViewModel = YourTopStrengthsViewModel()
    private val viewModel: YourTopStrengthsViewModel = viewModels

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
        holder.checkbox.text = item.styrkeName

        Log.d("getjafromadapter", viewModel.getja().toString())

        if (viewModel.getja()) {
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
//                is2Selected = true
//                viewModel.setIs2Selected(true)
                viewModel.setja(true)
                notifyDataSetChanged()
            } else {
//                is2Selected = false
//                viewModel.setIs2Selected(false)
                viewModel.setja(false)
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