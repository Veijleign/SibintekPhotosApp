package com.example.sibintektestapp

import com.example.sibintektestapp.model.ReceivedPhotosList.ReceivedDataItem

interface Navigator {
    fun showDetails(photo: ReceivedDataItem)

    fun goBack()
}