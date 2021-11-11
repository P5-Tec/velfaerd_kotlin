package com.example.vaelfardsapp

import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView

import com.example.vaelfardsapp.databinding.StyrkeFragmentItemBinding
import com.example.vaelfardsapp.models.styrkeModel
import java.io.InputStream

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class styrkeModelRecyclerViewAdapter(
    private val values: List<styrkeModel>
) : RecyclerView.Adapter<styrkeModelRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            StyrkeFragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
       // holder.styrkeName.text = item.styrkeName

        holder.styrkeImg.setImageResource(item.imagePath)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: StyrkeFragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //val styrkeName: TextView = binding.styrkeName
        val styrkeImg: ImageView = binding.styrkeImg
    }

}