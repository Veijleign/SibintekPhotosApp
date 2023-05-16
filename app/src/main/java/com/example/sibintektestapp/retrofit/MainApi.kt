package com.example.sibintektestapp.retrofit

import com.example.sibintektestapp.model.ReceivedPhotosList.ReceivedData
import com.example.sibintektestapp.model.ReceivedPhotosList.ReceivedDataItem
import com.example.sibintektestapp.model.moreImageInfo.DetailedImageInfo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface MainApi {

    @GET("photos/?client_id=_NbyEWYypdRsMndpUW-8JPIAlD1gk0fzG3jDLQrgtqM")
    suspend fun getData() : Response<ReceivedData>

    @GET("photos/?client_id=_NbyEWYypdRsMndpUW-8JPIAlD1gk0fzG3jDLQrgtqM")
    fun getDataTestCall() : Call<MutableList<ReceivedDataItem>>


    @GET("photos/bRRy9ucK1rY/?client_id=_NbyEWYypdRsMndpUW-8JPIAlD1gk0fzG3jDLQrgtqM")
    suspend fun getDetailedData() : Response<DetailedImageInfo>
}

/*
--> GET https://api.unsplash.com/photos/?%3Fclient_id%3D=_NbyEWYypdRsMndpUW-8JPIAlD1gk0fzG3jDLQrgtqM
--> GET https://api.unsplash.com/photos/?&client_id%3D=_NbyEWYypdRsMndpUW-8JPIAlD1gk0fzG3jDLQrgtqM
* */