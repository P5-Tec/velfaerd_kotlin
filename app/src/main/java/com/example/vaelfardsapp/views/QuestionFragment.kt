package com.example.vaelfardsapp.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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

    private val questionModel: QuestionsViewModel by viewModels()
    private var navFuse: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //TODO: Send content to view, implement slider, value check to stop progression without valid answer
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
            //change navigation path
            //if (navFuse){ findNavController().navigate(R.id.) }
            questionModel.nextQuestion().also {
                updateView()
                this.checkFuse()
            }
        }

        binding.btnTilbage.setOnClickListener {
            if (questionModel.getCurrentIndex == questionModel.getFirstIndex){
                findNavController().navigateUp()
            }
            questionModel.prevQuestion().also {
                this.updateView()
                binding.btnVidere.text = "Videre"
                if (navFuse){ navFuse = false }
            }
        }
    }

    private fun updateView(){
        questionSubheader!!.text = questionModel.currentQuestionSubHeader
        questionMaintext!!.text = questionModel.currentQuestionText
    }

    private fun checkFuse(){
        if (questionModel.getCurrentIndex == questionModel.getQuestionsMax){
            binding.btnVidere.text = "Afslut"
            navFuse = true
        }else{navFuse = false}
    }

    private fun saveAnswer(){
        //implement sharedPrefs
    }
}