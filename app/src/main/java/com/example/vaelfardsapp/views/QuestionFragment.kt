package com.example.vaelfardsapp.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.vaelfardsapp.R
import com.example.vaelfardsapp.databinding.FragmentQuestionBinding
import com.example.vaelfardsapp.viewmodels.QuestionsViewModel

class QuestionFragment : Fragment() {

    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!

    private var questionSubheader: TextView? = null
    private var questionMaintext: TextView? = null

    private val questionViewModel: QuestionsViewModel by viewModels()
    private var navFuse: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        questionSubheader = binding.questionSubheader
        questionMaintext = binding.questionMaintext
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.checkFuse()
        this.updateView()

        binding.btnVidere.setOnClickListener {
            saveAnswer()
            //if (navFuse){ findNavController().navigate(R.id.) }
            questionViewModel.nextQuestion().also {
                resetSlider()
                updateView()
                this.checkFuse()
            }
        }

        binding.btnTilbage.setOnClickListener {
            if (questionViewModel.getCurrentIndex == questionViewModel.getFirstIndex){
                resetSlider()
                findNavController().navigateUp()
            }
            questionViewModel.prevQuestion().also {
                resetSlider()
                this.updateView()
                binding.btnVidere.text = "Videre"
                if (navFuse){ navFuse = false }
            }
        }
    }

    private fun updateView(){
        questionSubheader!!.text = questionViewModel.currentQuestionSubHeader
        questionMaintext!!.text = questionViewModel.currentQuestionText
    }

    private fun checkFuse(){
        if (questionViewModel.getCurrentIndex == questionViewModel.getQuestionsMax){
            binding.btnVidere.text = "Afslut"
            navFuse = true
        }else{navFuse = false}
    }

    private fun saveAnswer(){
        //implement sharedPrefs
        Log.d("tag", "result saved: " + questionViewModel.questionAnswer.value.toString())
    }

    private fun resetSlider(){
        questionViewModel.resetSlider()
    }
}