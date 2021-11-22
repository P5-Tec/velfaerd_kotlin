package com.example.vaelfardsapp.views

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.vaelfardsapp.R
import com.example.vaelfardsapp.databinding.FragmentQuestionBinding
import com.example.vaelfardsapp.viewmodels.QuestionsViewModel
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.RawResourceDataSource

class QuestionFragment : Fragment() {

    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!


    private var questionSubheader: TextView? = null
    private var questionMaintext: TextView? = null

    private lateinit var playerView: PlayerView
    private lateinit var player: SimpleExoPlayer

    private val questionViewModel: QuestionsViewModel by viewModels()
    private var navFuse: Boolean = false

    private lateinit var sharedPrefs: SharedPreferences
    private val prefPrefix = "qpref" //prefix for SharedPreferences key value
    private lateinit var key: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs = context?.getSharedPreferences("questionsAns", MODE_PRIVATE)!!
        sharedPrefs?.edit().clear().apply()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        questionSubheader = binding.questionSubheader
        questionMaintext = binding.questionMaintext
        playerView = binding.playerView
        this.initPlayer()

        key = prefPrefix + questionViewModel.getCurrentIndex

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.updateView()

        binding.btnVidere.setOnClickListener {
            this.saveAnswer()
            questionViewModel.nextQuestion().also {
            if(questionViewModel.getCurrentIndex > questionViewModel.getFirstIndex){
                binding.btnTilbage.visibility = VISIBLE
            }
                //this.resetSlider()
                this.updateView()
                updateMediaItem(questionViewModel.currentQuestionVideo)
            }
        }

        binding.btnTilbage.setOnClickListener {
            questionViewModel.prevQuestion().also {
                if(questionViewModel.getCurrentIndex == questionViewModel.getFirstIndex){
                    binding.btnTilbage.visibility = GONE
                }
                //this.resetSlider()
                updateMediaItem(questionViewModel.currentQuestionVideo)
                this.updateView()
                binding.btnVidere.text = "Videre"
                if (navFuse){ navFuse = false }
            }
        }
    }

    private fun initPlayer(){
        val mediaItem = MediaItem.fromUri(RawResourceDataSource.buildRawResourceUri(questionViewModel.currentQuestionVideo))
        player = SimpleExoPlayer.Builder(requireContext()).build().also { exoPlayer ->
            playerView.player = exoPlayer               //binds together view and player
            playerView.controllerAutoShow = true        // show the play button
            playerView.controllerShowTimeoutMs = 800    //sets control fade time
            exoPlayer.playWhenReady = false             //change to true for autoplay
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
        }
    }

    private fun updateMediaItem(videoId: Int){
        val mediaItem = MediaItem.fromUri(RawResourceDataSource.buildRawResourceUri(videoId))
        player.setMediaItem(mediaItem)
    }

    private fun updateView(){
        key = prefPrefix + questionViewModel.getCurrentIndex
        Log.d("tag", "key value: $key")

        with(sharedPrefs?.getInt(key,questionViewModel.DEFAULT_SLIDER_VALUE)){
            Log.d("tag", "key is: $key + value is: $this" )
            questionViewModel.questionAnswer.value = this
        }

        questionSubheader!!.text = questionViewModel.currentQuestionSubHeader
        questionMaintext!!.text = questionViewModel.currentQuestionText
    }

    private fun saveAnswer(){
        val anws = questionViewModel?.questionAnswer.value
        with(sharedPrefs?.edit()){
            this?.putInt(key, anws!!)
            this?.commit()
            Log.d("tag", "Value is saved")
        }
    }

    private fun resetSlider(){
        with(sharedPrefs?.getInt(key,questionViewModel.DEFAULT_SLIDER_VALUE)){
            Log.d("tag", "key is: $key + value is: $this" )
            questionViewModel.questionAnswer.value = this
        }
    }
}