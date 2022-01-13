package com.example.vaelfardsapp.yourTopStrengths

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.vaelfardsapp.R
import com.example.vaelfardsapp.databinding.FragmentYourTopStrengthsBinding
import com.example.vaelfardsapp.viewmodels.YourTopStrengthsViewModel

class YourTopStrengths : Fragment() {

    private var _binding: FragmentYourTopStrengthsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: YourTopStrengthsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentYourTopStrengthsBinding.inflate(inflater, container, false)

        binding.btnTilbage.setOnClickListener {
            findNavController().navigate(R.id.action_yourTopStrengthsBackNavigation)
        }

        binding.btnVidere.setOnClickListener {
            findNavController().navigate(R.id.action_yourTopStrengths_to_sendResultFragment)
        }

        viewModel.is2Selected.observe(viewLifecycleOwner, {
            binding.btnVidere.isEnabled = it
        })

        return binding.root
    }

}