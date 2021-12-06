package com.example.vaelfardsapp.yourTopStrengths

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.vaelfardsapp.R
import com.example.vaelfardsapp.databinding.FragmentYourTopStrengthsBinding

class YourTopStrengths : Fragment() {

    private var _binding: FragmentYourTopStrengthsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentYourTopStrengthsBinding.inflate(inflater, container, false)

        binding.btnForrige.setOnClickListener{
            findNavController().navigate(R.id.action_yourTopStrengthsBackNavigation)
        }


        return binding.root
    }

}