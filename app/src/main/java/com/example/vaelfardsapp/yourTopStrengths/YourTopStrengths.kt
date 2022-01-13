package com.example.vaelfardsapp.yourTopStrengths

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.vaelfardsapp.R
import com.example.vaelfardsapp.databinding.FragmentYourTopStrengthsBinding
import com.example.vaelfardsapp.viewmodels.YourTopStrengthsViewModel
import java.util.*

class YourTopStrengths : Fragment() {

    private var _binding: FragmentYourTopStrengthsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: YourTopStrengthsViewModel by viewModels()
//    private val viewModel: YourTopStrengthsViewModel by activityViewModels()

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

//        binding.strengthsList.setOnClickListener {
//            Log.d("rvOnClick", "true")
//            binding.btnVidere.isEnabled = viewModel.getIs2Selected()
//        }



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.ja.observe(viewLifecycleOwner, androidx.lifecycle.Observer { value ->
            Log.d("observed", value.toString())
            binding.btnVidere.isEnabled = value
        })
    }
}