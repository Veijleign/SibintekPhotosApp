package com.example.sibintektestapp.tasks

typealias CallBack<T> = (T) -> Unit

interface Task<T> {

    fun onSuccess(callback: CallBack<T>): Task<T> // задача выдаёт успех // подписаться на результат

    fun onError(callback: CallBack<Throwable>): Task<T> // задача выдаёт ошибку // подписаться на ошибки

    fun cancel() // можемм отменить // если уходим с экран, а запрос ещё не завершился

    fun await(): T // дождаться результата синхронно

}