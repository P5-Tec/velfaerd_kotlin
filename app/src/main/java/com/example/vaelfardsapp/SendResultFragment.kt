package com.example.vaelfardsapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import com.example.vaelfardsapp.databinding.FragmentSendResultBinding
import java.io.File
import java.io.FileOutputStream


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

            val subject = "My test subject"
            val vigtigString = "My very important test message."

//            val address: ArrayList<String> = ArrayList()
//            address.add("testemail1@gmail.com")
//            address.add("testemail2@gmail.com")
//            val addresses = arrayOf(binding.emailInput.toString(), "testmail@gmail.com")

//            val email1: String = binding.emailInput.text.toString()
            val emails: Array<String> = arrayOf(binding.emailInput.text.toString())

            composeEmail(emails, subject, vigtigString)
        }

        return binding.root
    }

    private fun composeEmail(address: Array<String>, subject: String, message: String) {
        val intent = Intent(Intent.ACTION_SEND)
//        intent.data = Uri.parse("mailto:")
//        intent.type = "message/rfc822"
//            data = Uri.parse("mailto:") // Only email apps will respond to this
//        intent.type = "*/*"

//        intent.putExtra(Intent.EXTRA_EMAIL, address) // Emailaddresses to send to
//        intent.putExtra(Intent.EXTRA_SUBJECT, subject) // Email subject string
//        intent.putExtra(Intent.EXTRA_TEXT, message) // Text to send via email


//        val uri: Uri = Uri.parse(
//            ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + resources.getResourcePackageName(R.drawable.kat)
//                    + '/' + resources.getResourceTypeName(R.drawable.kat) + '/' + resources.getResourceEntryName(
//                R.drawable.kat
//            )
//        )

//        val uri = Uri.parse(
//            ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + resources.getResourcePackageName(R.drawable.kat1)
//                    + '/' + resources.getResourceTypeName(R.drawable.kat1) + '/' + resources.getResourceEntryName(
//                R.drawable.kat1
//            )
//        )

//        val filename = "kat1.png"
//        val filelocation = File(context?.filesDir, filename)
//        val uri = Uri.fromFile(filelocation)

//        val imagePath = File(context?.getExternalFilesDir("kat1.png"), "files")
//        val newFile = File(context?.getExternalFilesDir("kat1.png"), "")
//        val uri: Uri =
//            getUriForFile(requireContext(), "com.example.vaelfardsapp.fileprovider", newFile)

//        val uri: Uri = Uri.parse("android.resource://com.example.vaelfardsapp/drawable/kat")
//        val uri: Uri =
//            Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context?.packageName + "/drawable/kat1")
//        val uri: Uri = requireContext().resourceUri(R.drawable.kat1)

//        val imagePath = File(context?.filesDir, "files")
//        val newFile = File(imagePath, "kat.png")
//        val uri: Uri =
//            getUriForFile(requireContext(), "com.example.vaelfardsapp.fileprovider", newFile)

//        val otherPath = Uri.parse("android.resource://com.example.vaelfardsapp/drawable/kat")

//        val uri3 : Uri = FileProvider.getUriForFile(requireContext(), "com.example.vaelfardsapp.fileprovider", kat.png)

//        val imageUri = "drawable://" + R.drawable.kat
//        val uri = Uri.parse(imageUri)

//        val imagePath = File(requireContext().filesDir, "drawable")
//        val newFile = File(imagePath, "kat.png")
//        val contentUri = getUriForFile(requireContext(), "com.example.vaelfardsapp.fileprovider", newFile)
//        Log.d("uri", contentUri.toString())

//        val uri: Uri = Uri.parse(binding.imgView.drawable.toString())

//        val bitmapDrawable: BitmapDrawable = (BitmapDrawable) binding.imgView.drawable
//        val bitmap: Bitmap = binding.imgView.drawable.toBitmap()
//        val uri: Uri? = getmageToShare(bitmap)

//        val drawable: Drawable = binding.imgView.drawable
//        val bitmap = (drawable as BitmapDrawable).bitmap
//        val file = File(
//            context?.filesDir, "drawable"
//        )
//        val fOut = FileOutputStream(file)
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut)
//        fOut.flush()
//        fOut.close()
//        file.setReadable(true, false)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//        val uri =
//            getUriForFile(requireContext(), BuildConfig.APPLICATION_ID + ".fileprovider", file)


//        val uris = arrayListOf<Uri>()
//        uris.add(uri)

//        intent.type = "image/png"
//        intent.type = "application/image"


//        val imagePath = File(context?.filesDir, "myimages")
//        val newFile = File(imagePath, "kat1.png")
//        Log.d("myfile", newFile.absolutePath)
//        newFile.setReadable(true, false)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//        if (newFile.exists()) {
//            Log.d("logaccess", "file exists")
//
//        }
//        val uri = getUriForFile(
//            requireContext(), "com.example.vaelfardsapp.fileprovider", newFile
//        )









        val drawable: Drawable = binding.imgView.drawable
        val bitmap: Bitmap = drawable.toBitmap()
        val file: File = File(context?.filesDir, File.separator + "kat1.png")
        val fOut: FileOutputStream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut)
//        fOut.flush()
//        fOut.close()
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        val uri: Uri = FileProvider.getUriForFile(requireContext(), "com.example.vaelfardsapp.fileprovider", file)

        if (uri.isAbsolute) {
            Log.d("logaccess", "file exists")

        }








//        val imagePath: File = File(Context.getFilesDir(), "my_images")
//        val newFile = File(imagePath, "default_image.jpg")
//        val contentUri: Uri = getUriForFile(context?, "com.mydomain.fileprovider", newFile)


//        val fileName = "kat1.png"
//        val file = File(context?.filesDir, fileName)
//        val uri = getUriForFile(
//            requireContext().applicationContext,
//            "com.example.vaelfardsapp.fileprovider",
//            file
//        )

//        val packageName = context?.packageName
//        Log.d("packname", packageName!!)

//        context?.grantUriPermission(
//            "com.example.vaelfardsapp",
//            uri,
//            Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
//        )

        Log.d("uri", uri.toString())
        intent.putExtra(Intent.EXTRA_STREAM, uri)

        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
//        intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
//        intent.flags = Intent.FLAG_GRANT_WRITE_URI_PERMISSION

        intent.type = "image/png"

//        intent.data = uri

//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)


        val chooser = Intent.createChooser(intent, "fucking send allerede")
        startActivity(chooser)
    }

//    private fun Context.resourceUri(resourceId: Int): Uri = with(resources) {
//        Uri.Builder()
//            .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
//            .authority(getResourcePackageName(resourceId))
//            .appendPath(getResourceTypeName(resourceId))
//            .appendPath(getResourceEntryName(resourceId))
//            .build()
//    }
//
//    private fun Resources.getRawUri(@RawRes rawRes: Int) = "%s://%s/%s/%s".format(
//        ContentResolver.SCHEME_ANDROID_RESOURCE, this.getResourcePackageName(rawRes),
//        this.getResourceTypeName(rawRes), this.getResourceEntryName(rawRes)
//    )

}