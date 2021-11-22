package com.example.vaelfardsapp.expandableListView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.vaelfardsapp.constants.Questions
import com.example.vaelfardsapp.databinding.FragmentStrengthsExpandableListViewBinding
import com.example.vaelfardsapp.models.questionModel

class StrengthsExpandableListView : Fragment() {

    private var _binding: FragmentStrengthsExpandableListViewBinding? = null
    private val binding get() = _binding!!

    private var modelArray: ArrayList<questionModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStrengthsExpandableListViewBinding.inflate(inflater, container, false)

        modelArray = Questions.getQuestions()

        binding.expandableListView.setAdapter(StrengthsExpandableListAdapter(context, modelArray))

        return binding.root
    }
}