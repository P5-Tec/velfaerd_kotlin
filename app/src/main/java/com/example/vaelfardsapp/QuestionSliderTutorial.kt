package com.example.vaelfardsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.vaelfardsapp.databinding.FragmentQuestionSliderTutorialBinding

class QuestionSliderTutorial : Fragment() {

    private var _binding: FragmentQuestionSliderTutorialBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentQuestionSliderTutorialBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnVidere.setOnClickListener {
            findNavController().navigate(R.id.action_questionSliderTutorial_to_questionFragment)
        }
    }
}