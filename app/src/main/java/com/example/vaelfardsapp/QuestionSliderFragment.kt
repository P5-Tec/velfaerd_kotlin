package com.example.vaelfardsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.vaelfardsapp.databinding.FragmentQuestionSliderBinding

class QuestionSliderFragment : Fragment() {

    private lateinit var _binding: FragmentQuestionSliderBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentQuestionSliderBinding.inflate(inflater,container,false)

        binding.slider.addOnChangeListener { slider, value, fromUser ->
            Log.i("Slider", "${value.toInt()}")
            Toast.makeText(context, "Slider value: $value", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }


}