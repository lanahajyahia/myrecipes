package com.example.myrecipes.ui.fragments.uploadimagerecipe

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.myrecipes.R
import com.example.myrecipes.databinding.FragmentUploadImageRecipeBinding
import com.example.myrecipes.databinding.FragmentUploadRecipesBinding
import com.example.myrecipes.models.ImageItem
import com.example.myrecipes.models.SliderItem
import com.example.myrecipes.viewmodels.MainViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ListResult
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class UploadImageRecipeFragment : Fragment() {
    private val mainViewModel by viewModels<MainViewModel>()

    private var _binding: FragmentUploadImageRecipeBinding? = null
    private val binding get() = _binding!!

    //    lateinit var uploadedRecipeImg: ImageView
    lateinit var imgURI: Uri //img uri uploaded from gallery
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUploadImageRecipeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
//      binding.mainViewModel = mainViewModel


        binding.recipesUploadImageFab?.setOnClickListener {
            selectImgFromGallery()
        }
        val imageList = ArrayList<SlideModel>() // Create image list

        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference.child("images")
        val imageArrayList: ArrayList<SlideModel> = ArrayList()

        val listAllTask: Task<ListResult> = storageRef.listAll()
        listAllTask.addOnCompleteListener{ result ->
            val items: List<StorageReference> = result.result!!.items
            items.forEachIndexed {
                index, item ->
                item.downloadUrl.addOnSuccessListener {
                    imageArrayList.add(SlideModel(it.toString()))
                }.addOnCompleteListener {
                    binding.imageSlider.stopSliding()
                    binding.imageSlider.setImageList(imageArrayList)
                }
            }
        }

//        imageList.add(SlideModel("https://bit.ly/2YoJ77H", "Recipe 1"))
//        imageList.add(
//            SlideModel(
//                "https://bit.ly/2BteuF2",
//                "Elephants and tigers may become extinct."
//            )
//        )
//        imageList.add(SlideModel("https://bit.ly/3fLJf72", "And people do that."))



        return binding.root

    }

    private fun uploadImgToFirebase() {
//        val progressBar = ProgressBar(this)
//        progressBar.setMessage("uploading")
//        progressBar.setCancebale(false)
//        progressBar.show()

        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val fileName = formatter.format(now)
        val storageReference = FirebaseStorage.getInstance().getReference("images/$fileName")

        storageReference.putFile(imgURI).addOnSuccessListener {

//            uploadedRecipeImg.setImageURI(null)
            Toast.makeText(context, "added image", Toast.LENGTH_SHORT).show()

        }.addOnFailureListener {
            Toast.makeText(context, "error uploading image", Toast.LENGTH_SHORT).show()
        }


    }

    private fun selectImgFromGallery() {

        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(intent, 100)
    }

    // this method will be called when the user selected an image from the gallery
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            imgURI = data?.data!!
//            uploadedRecipeImg.setImageURI(imgURI)
            uploadImgToFirebase()

        }
    }

}