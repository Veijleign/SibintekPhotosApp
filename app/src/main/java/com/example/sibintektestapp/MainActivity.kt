package com.example.sibintektestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sibintektestapp.databinding.ActivityMainBinding
import com.example.sibintektestapp.model.ReceivedPhotosList.ReceivedDataItem
import com.example.sibintektestapp.model.moreImageInfo.DetailedImageInfo
import com.example.sibintektestapp.retrofit.common.Common
import com.example.sibintektestapp.screens.PhotosListFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        getData()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, PhotosListFragment())
                .commit()
        }
    }
}

fun getData() {
    var data: ArrayList<ReceivedDataItem>
    var detailedData: DetailedImageInfo
    val photos: MutableList<ReceivedDataItem> = ArrayList()
    CoroutineScope(Dispatchers.IO).launch {

        val dataTest = Common.retrofitService.getDataTestCall()

        dataTest.enqueue(object : Callback<MutableList<ReceivedDataItem>> {
            override fun onResponse(
                call: Call<MutableList<ReceivedDataItem>>,
                response: Response<MutableList<ReceivedDataItem>>
            ) {
                if (response.isSuccessful) {
                    photos.clear()
                    Log.d("Sibintek", "DATA FROM <CALL>: ${response.body()}")
                    response.body()?.let { photos.addAll(it) }
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


        // for test and fun (look like correct). Запрос на данные внутри картинки
        val responseForDetailedImageInfo = Common.retrofitService.getDetailedData()
        Log.d("Sibintek", "RECEIVED DETAILED DATA: ${responseForDetailedImageInfo.body()}")
        detailedData = responseForDetailedImageInfo.body()!!
        Log.d("Sibintek", "MORE INFO: ${detailedData.links.download}")

        // задачи 1 - сделать запрос на внутри картинки
        // 2 - сделать recyclerView с адаптером и тесстовыи данными
    }
}
