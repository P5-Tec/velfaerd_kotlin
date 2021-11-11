package com.example.vaelfardsapp.expandableListView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.vaelfardsapp.constants.Styrker
import com.example.vaelfardsapp.databinding.FragmentStrengthsExpandableListViewBinding
import com.example.vaelfardsapp.models.StyrkeModel

class StrengthsExpandableListView : Fragment() {

    private var _binding: FragmentStrengthsExpandableListViewBinding? = null
    private val binding get() = _binding!!

    private var modelArray: ArrayList<StyrkeModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStrengthsExpandableListViewBinding.inflate(inflater, container, false)

        modelArray = Styrker.getStyrker()

        binding.expandableListView.setAdapter(StrengthsExpandableListAdapter(context, modelArray))

        return binding.root
    }
}