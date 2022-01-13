package com.example.vaelfardsapp.yourTopStrengths

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vaelfardsapp.R
import com.example.vaelfardsapp.constants.Questions
import com.example.vaelfardsapp.models.questionModel
import com.example.vaelfardsapp.viewmodels.QuestionsViewModel
import com.example.vaelfardsapp.viewmodels.YourTopStrengthsViewModel

class YourTopStrengthsItemFragment : Fragment() {

    private var columnCount = 1

    private val questionViewModel: QuestionsViewModel by viewModels()
    private val yourTopStrengthsViewModel: YourTopStrengthsViewModel by activityViewModels()
    private val qs = Questions
    private val newItems = arrayListOf<questionModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val answers = questionViewModel.getAnswersFromSP(requireContext())
        val questions = qs.getQuestions()

        for ((i, _) in answers.withIndex()) {
            newItems.add(questions[answers[i][0]])
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(R.layout.fragment_your_top_strengths_recyclerview, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                adapter = YourTopStrengthsRecyclerViewAdapter(newItems, yourTopStrengthsViewModel)
            }
        }
        return view
    }
}