package com.example.sibintektestapp.model

import com.example.sibintektestapp.model.ReceivedPhotosList.ReceivedDataItem
import com.example.sibintektestapp.tasks.SimpleTask
import com.example.sibintektestapp.tasks.Task
import java.util.concurrent.Callable

typealias PhotosListener = (photos: List<ReceivedDataItem>) -> Unit// объявление типа слушателя // для паттерна observer // отдача списка пользователей после изменений

// слой модели данных, здесь получаются данные
class PhotoService {

    private var photos = mutableListOf<ReceivedDataItem>()
    private var loaded = false // флаг для проверки загружено ли

    private val listeners = mutableSetOf<PhotosListener>() // слушатели для всех изменений в этом классе

    // переделаем на Unit, т.к. есть слушатели которые уведомляют о том, что пришли пользователи
    fun loadPhotos(): Task<Unit> = SimpleTask<Unit>(Callable {
        Thread.sleep(2000) // задержка, заменить потом на Retrofit
        loaded = true
        notifyChanges()
    })

    fun addListener(listener: PhotosListener) {
        listeners.add(listener)
        if (loaded) { // вызываем слушателя только если есть список
            listener.invoke(photos) // вызов слушателя
        }
    }

    fun removeListener(listener: PhotosListener) {
        listeners.remove(listener)
    }

    fun notifyChanges() {
        if (!loaded) return // если не loaded
        listeners.forEach { it.invoke(photos) }
    }

    companion object {
        val IMAGES = mutableListOf<ReceivedDataItem>() // здесь фото, написвно чтобы запомнить
    }

}