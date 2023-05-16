package com.example.sibintektestapp.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sibintektestapp.PhotoActionListener
import com.example.sibintektestapp.model.PhotoService
import com.example.sibintektestapp.model.PhotosListener
import com.example.sibintektestapp.model.ReceivedPhotosList.ReceivedDataItem
import com.example.sibintektestapp.tasks.EmptyResult
import com.example.sibintektestapp.tasks.SuccessResult

data class PhotosListItem(
    val photo: ReceivedDataItem, // фото приходят из модели
    val isInProgress: Boolean // данные о состоянии, хранятся тут, а не в модели
)

class PhotosListViewModel(
    private val photosService: PhotoService// в конструктор модели передать все зависимости, от которых она зависит
) : BaseViewModel(), PhotoActionListener {
    // во ViewModel описать операции, которые разрешено делать из фрагмента а также данные, которые ViewModel будет отпраавлять во фрагмент

    private val _photos = MutableLiveData<Result<List<PhotosListItem>>>() // не может изменять данные здесь
    val photos: LiveData<Result<List<PhotosListItem>>> = _photos // может слушать данные здесь

    private val _actionShowDetails = MutableLiveData<Event<ReceivedDataItem>>() // Event LiveData для запуска деталей // передаём пользователя, детали которого нужно показать
    val actionShowDetails: LiveData<Event<ReceivedDataItem>> = _actionShowDetails

    private val photosIdsInProgress = mutableSetOf<Long>() // набор id которые сейчас в обработке
    private var photosResult: Result<List<ReceivedDataItem>> = EmptyResult() // хранение текущего результата
        set(value) {
            field = value
            notifyUpdates()
        }

    private val listener: PhotosListener = {
        _photos.value = if (it.isEmpty()) {
            EmptyResult()
        } else {
            SuccessResult(it)
        }
    }

    init {
        loadPhotos()
    }

    override fun onCleared() {
        super.onCleared()
        photosService.removeListener(listener)// чтобы не было утечек памяти, т.к. PhotosService живёт дольше и его ЖЦ больше чем у ViewModel
    }

    //реализация основных функций
    fun loadPhotos() {
        photosService.addListener(listener)
    }

    private fun isInProgress(photo: ReceivedDataItem): Boolean { // проверка, является ли пользователь сейчас в обработке
        return photosIdsInProgress.contains(photo.id)
    }

    private fun notifyUpdates() {
        _photos.postValue(photosResult.map { photos ->// postValue предназначем для случав, когда мы получаем данные в другом потоке, но с LiveData надо работать в главном потоке,
                                                      // postValue внутри себя передаст дальше в LiveData фрагмента в главном потоке, независимо от того где мы находимся
            photos.map { photo -> PhotosListItem(photo, isInProgress(photo))}
        })
    }

    override fun onPhotoDetails(photo: ReceivedDataItem) {
        TODO("Not yet implemented")
    }

}