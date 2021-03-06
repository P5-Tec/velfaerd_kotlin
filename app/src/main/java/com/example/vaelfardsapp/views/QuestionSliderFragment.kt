package com.example.vaelfardsapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.vaelfardsapp.databinding.FragmentQuestionSliderBinding
import com.example.vaelfardsapp.viewmodels.QuestionsViewModel

class QuestionSliderFragment : Fragment() {

    private lateinit var _binding: FragmentQuestionSliderBinding
    private val binding get() = _binding

    private val viewModel: QuestionsViewModel by viewModels({ requireParentFragment() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentQuestionSliderBinding.inflate(inflater, container, false)

        viewModel.questionAnswer.observe(viewLifecycleOwner, {
            binding.slider.value = viewModel.returnValFloat!!
        })

        binding.slider.addOnChangeListener { _, value, _ ->
            viewModel.questionAnswer.value = value.toInt()
        }

        return binding.root
    }
}