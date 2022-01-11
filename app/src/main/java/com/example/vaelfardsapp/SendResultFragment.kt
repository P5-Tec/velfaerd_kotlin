package com.example.vaelfardsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider.getUriForFile
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.vaelfardsapp.databinding.FragmentSendResultBinding
import java.io.File

class SendResultFragment : Fragment() {

    private var _binding: FragmentSendResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSendResultBinding.inflate(inflater, container, false)

        binding.btnSend.setOnClickListener {
            shareWithIntent()
        }

        binding.btnTilbage.setOnClickListener {
            findNavController().navigate(R.id.action_sendResultBackNavigation)
        }

        return binding.root
    }

    private fun shareWithIntent() {
        val intent = Intent(Intent.ACTION_SEND)

        intent.type = "image/png"

        var uri = Uri.parse("")

        val imagePath = File(context?.filesDir, "")
        val file = File(imagePath, "kat1.png")
        if (file.exists()) {

            uri = getUriForFile(
                requireContext(), "com.example.vaelfardsapp.fileprovider", file
            )
        }

        intent.putExtra(Intent.EXTRA_STREAM, uri)

//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

        // The chooser is the cause of the "SecurityException: Permission Denial" error when sending the image with intent
        // The code executes just fine however
        startActivity(Intent.createChooser(intent, null))
    }

}