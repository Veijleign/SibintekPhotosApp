package com.example.sibintektestapp

import android.app.Application
import com.example.sibintektestapp.model.PhotoService

class App : Application() {
    val photoService = PhotoService()
}