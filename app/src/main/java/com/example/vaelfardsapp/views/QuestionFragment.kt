package com.example.vaelfardsapp.views

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.vaelfardsapp.R
import com.example.vaelfardsapp.databinding.FragmentQuestionBinding
import com.example.vaelfardsapp.viewmodels.QuestionsViewModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.RawResourceDataSource

class QuestionFragment : Fragment() {

    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!

    private lateinit var playerView: PlayerView
    private lateinit var player: ExoPlayer

    private val questionViewModel: QuestionsViewModel by viewModels()
    private lateinit var sharedPrefs: SharedPreferences
    private val key = "questionsKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPrefs = context?.getSharedPreferences("questionsAns", MODE_PRIVATE)!!
        sharedPrefs.edit().clear().apply()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)

        playerView = binding.playerView
        this.initPlayer()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.updateView()

        binding.btnVidere.setOnClickListener {
            this.saveAnswer()

            if (questionViewModel.getCurrentIndex != questionViewModel.getQuestionsMax) {
                questionViewModel.nextQuestion().also {
                    if (questionViewModel.getCurrentIndex > questionViewModel.getFirstIndex) {
                        binding.btnTilbage.visibility = VISIBLE
                    }
                    if (questionViewModel.getCurrentIndex == questionViewModel.getQuestionsMax) {
                        binding.btnVidere.text = getString(R.string.udfoer_text)
                    }

                    this.updateView()
                    updateMediaItem(questionViewModel.currentQuestionVideo)
                }
            } else {
                findNavController().navigate(R.id.action_questionFragment_to_yourTopStrengths)
            }
        }

        binding.btnTilbage.setOnClickListener {
            questionViewModel.prevQuestion().also {
                if (questionViewModel.getCurrentIndex == questionViewModel.getFirstIndex) {
                    binding.btnTilbage.visibility = GONE
                }

                updateMediaItem(questionViewModel.currentQuestionVideo)
                this.updateView()
            }
        }

        // FIXME - TEMPORARY BUTTON TO SKIP QUESTIONS, DELETE BEFORE RELEASE
        binding.btnSkipTemp?.setOnClickListener {
            questionViewModel.skipQuestions()
            this.updateView()
        }
    }

    private fun initPlayer() {
        val mediaItem =
            MediaItem.fromUri(RawResourceDataSource.buildRawResourceUri(questionViewModel.currentQuestionVideo))
        player = ExoPlayer.Builder(requireContext()).build().also { exoPlayer ->
            playerView.player = exoPlayer               // binds together view and player
            playerView.controllerAutoShow = true        // show the play button
            playerView.controllerShowTimeoutMs = 800    // sets control fade time
            exoPlayer.playWhenReady = false             // change to true for autoplay
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
        }
    }

    private fun updateMediaItem(videoId: Int) {
        val mediaItem = MediaItem.fromUri(RawResourceDataSource.buildRawResourceUri(videoId))
        player.setMediaItem(mediaItem)
    }

    private fun updateView() {

        with(sharedPrefs.getInt(key, questionViewModel.defaultSliderValue)) {
            questionViewModel.questionAnswer.value = this
        }

        binding.questionSubheader.text = questionViewModel.currentQuestionSubHeader
        binding.questionMaintext.text = questionViewModel.currentQuestionText
    }

    // 2D Array
    private val array2d = Array(24) { IntArray(2) }

    private fun saveAnswer() {
        val anws = questionViewModel.questionAnswer.value

        // Adding the index(Question number) and answer to 2d array
        array2d[questionViewModel.getCurrentIndex][0] = questionViewModel.getCurrentIndex
        array2d[questionViewModel.getCurrentIndex][1] = anws!!

        Log.d("array2dFromSP", questionViewModel.getCurrentIndex.toString())
        Log.d("array2dFromSP", questionViewModel.getQuestionsMax.toString())

        if (questionViewModel.getCurrentIndex == questionViewModel.getQuestionsMax) {
            questionViewModel.saveAnswersToSP(requireContext(), array2d)
        }
    }

}