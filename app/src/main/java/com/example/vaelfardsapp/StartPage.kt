package com.example.vaelfardsapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vaelfardsapp.databinding.FragmentStartPageBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.RawResourceDataSource

class StartPage : Fragment() {

    private var _binding: FragmentStartPageBinding? = null
    private val binding get() = _binding!!

    private lateinit var playerView: PlayerView
    private lateinit var player: SimpleExoPlayer
    private val path: Uri = RawResourceDataSource.buildRawResourceUri(R.raw.introvid)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStartPageBinding.inflate(inflater, container, false)

        playerView = binding.playerView!!
        player = SimpleExoPlayer.Builder(requireContext()).build().also { exoPlayer ->
            playerView.player = exoPlayer
            playerView.hideController()
            playerView.controllerShowTimeoutMs = 800
            //set media file
            val mediaItem = MediaItem.fromUri(path)
            exoPlayer.setMediaItem(mediaItem)
            //prepare for playback
            exoPlayer.prepare()
            exoPlayer.playWhenReady = true
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        if (!player.isPlaying){
            player.play()
        }
    }

    override fun onPause() {
        super.onPause()
        if (player.isPlaying){
            player.pause()
        }
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            StartPage().apply {
            }
    }
}