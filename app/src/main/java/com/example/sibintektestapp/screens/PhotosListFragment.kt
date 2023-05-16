package com.example.sibintektestapp.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sibintektestapp.ImageItemAdapter
import com.example.sibintektestapp.PhotoActionListener
import com.example.sibintektestapp.R
import com.example.sibintektestapp.databinding.FragmentPhotosListBinding
import com.example.sibintektestapp.model.ReceivedPhotosList.ReceivedDataItem
import com.example.sibintektestapp.retrofit.common.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosListFragment : Fragment() {

    private lateinit var binding: FragmentPhotosListBinding
    private lateinit var adapter: ImageItemAdapter
    private var photos: MutableList<ReceivedDataItem> = ArrayList()
    private var sort: String = "popular"

    private val viewModel: PhotosListViewModel by viewModels { factory() }  // поле для доступа к ViewModel, в качестве аргемента можно передать фабрику ViewModel'ей
    // каждый раз когда надо создать ViewModel даже для другого экрана использовать эту контсрукцию
    // если viewModel бех контсруктора, то фабрики создавать не нужно

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_photos_list, container, false)
        binding = FragmentPhotosListBinding.bind(view)
        adapter = ImageItemAdapter(
            object : PhotoActionListener {
                override fun onPhotoDetails(photo: ReceivedDataItem) {
                    navigator().showDetails(photo)
                }
            },
            photos,
            requireContext()
        )

        viewModel.photos.observe(viewLifecycleOwner, Observer {
            adapter.photos = it as MutableList<ReceivedDataItem>
        })

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        getImages()

        // TODO MUST BE CHECKED
        //return view
        return binding.root
    }

    private fun getImages() {

        val mService = Common.retrofitService.getDataTestCall()
        mService.enqueue(object : Callback<MutableList<ReceivedDataItem>> {
            override fun onResponse(
                call: Call<MutableList<ReceivedDataItem>>,
                response: Response<MutableList<ReceivedDataItem>>
            ) {
                if (response.isSuccessful) {
                    photos.clear()
                    Log.d("Sibintek", "DATA FROM <CALL>: ${response.body()}")
                    response.body()?.let { photos.addAll(it) }
                    adapter.notifyDataSetChanged()
                    photos.forEachIndexed { index, item ->
                        Log.d("Sibintek", "PHOTOS ARRAY ITEM $index. DATA: $item") // item = ReceivedDataItem
                    }
                } else {
                    Log.d("Sibintek", "DATA FROM <CALL> (ELSE): ${response.body()}")
                }
            }

            override fun onFailure(call: Call<MutableList<ReceivedDataItem>>, t: Throwable) {
                Log.d("Sibintek", "Failed")
            }
        })



        //responseForPhotos.body()?.let { photos.addAll(it) }




    }
}