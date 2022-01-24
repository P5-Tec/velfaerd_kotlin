package com.example.vaelfardsapp

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.vaelfardsapp.databinding.FragmentStartPageBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.google.android.material.color.DynamicColors

class StartPage : Fragment() {

    private var _binding: FragmentStartPageBinding? = null
    private val binding get() = _binding!!

    private lateinit var playerView: PlayerView
    private lateinit var player: ExoPlayer
    private val path: Uri = RawResourceDataSource.buildRawResourceUri(R.raw.introvid)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStartPageBinding.inflate(inflater, container, false)

        playerView = binding.playerView
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnVidere.setOnClickListener { findNavController().navigate(R.id.action_startPage_to_questionFragment) }
        binding.btnStyrker.setOnClickListener {
            findNavController().navigate(R.id.action_startPage_to_strengthsExpandableListView)
        }
        initPlayer()
    }

    override fun onPause() {
        super.onPause()
        if (player.isPlaying) { player.pause() }
    }

    private fun initPlayer() {
        val mediaItem = MediaItem.fromUri(path)
        player = ExoPlayer.Builder(requireContext()).build().also { exoPlayer ->
            playerView.player = exoPlayer //binds together view and player
            playerView.controllerAutoShow = true
            playerView.controllerShowTimeoutMs = 800 //sets control fade time
            exoPlayer.addMediaItem(mediaItem) //set media file
            exoPlayer.playWhenReady = false //change to true for autoplay
            exoPlayer.prepare()
        }
    }
}