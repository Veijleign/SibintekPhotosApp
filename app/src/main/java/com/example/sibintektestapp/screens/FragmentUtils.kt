package com.example.sibintektestapp.screens

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sibintektestapp.App
import com.example.sibintektestapp.Navigator
import java.lang.IllegalStateException

// доп классы для работы с фрагмента
// задача фабрики VoewModel - создавать ViewModel, с нужными параметрами, которые передаются в конструктор
class ViewModelFactory(
    private val app: App

) : ViewModelProvider.Factory {

    // в качестве аргумента приходит класс ViewModel, затем отдаётся сама созданная ViewModel
    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        val viewModel = when(modelClass) {
            PhotosListFragment::class.java -> { // если класс который пришёл подходит
                PhotosListViewModel(app.photoService) // то создаём viewModel
            }
            PhotoDetailsViewModel::class.java -> {
                PhotoDetailsViewModel(app.photoService)
            }
            else -> {
                throw IllegalStateException("Unknown ViewModel Class")
            }
        }
        return viewModel as T
    }
}

fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as App) // App т.к. зарегистрирован в манифесте !!!!

fun Fragment.navigator() = requireActivity() as Navigator // везде где переходы между экранами вызывать navigator и добавить соответствующие логики