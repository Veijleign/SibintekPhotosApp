package com.example.sibintektestapp.screens

import androidx.lifecycle.ViewModel
import com.example.sibintektestapp.tasks.Task


//задачи могут отменяться, например если мы уходим с экрана раньше чем задача завершилась
// для этого создан этот класс
open class BaseViewModel : ViewModel() {

    private val tasks = mutableListOf<Task<*>>() // список задач, которые нужно отменить

    override fun onCleared() {
        super.onCleared()
        tasks.forEach {
            it.cancel() // проходимся по каждой задаче и отменяем их
        }
    }
    // extension метод
    fun <T> Task<T>.autoCancel() { // если мы на задаче вызовем autoCancel, то она автоматически отменится при вничтожении ViewModel
        tasks.add(this) // добавление задачи в список

    }
}

// архитектура MVVM во ViewModel позволяют отправлять view состояния, но не позволяют отправлять какие-то единичные события (например показать Toast)
// как вариант возможно использование Event
class Event<T>( // каждый элемент который послан в event будет обработан только 1 раз
    private val value: T
) {
    private var handled: Boolean = false // бработано это событие или нет

    fun getValue(): T? {
        if (handled) return null // но когда вызовется 2 раз getValue, то уже ничего не сработает
        handled = true
        return value // значение event вернётся во фрагмент
    }
}