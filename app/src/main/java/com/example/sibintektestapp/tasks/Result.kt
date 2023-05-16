package com.example.sibintektestapp.tasks

sealed class Result<T> {

    fun <R> map(mapper: (T) -> R): // объявялем функцию, которая принимает T, а на выходе выдaёт R
            Result<R> { // метод для преобразования результатов из одного типа в другой тип
        if (this is SuccessResult) return SuccessResult(mapper(data)) // если SuccessResult то создаём новый SuccessResult,
        // затем с помощью функции mapper преобразуем данные которые есть в SuccessResult, имеющие тип Т, в тип R
        return this as Result<R> // во всех других случаях без разницы
    }
}

class SuccessResult<T>( // если операция завершилась успешно и она содержит результат
    val data: T
) : Result<T>()

class ErrorResult<T>( // если операция завершилась с ошибкой и она содержит ршибку
    val error: Throwable
) : Result<T>()

class PendingResult<T> : Result<T>() // задача ещё не завершилась, она в процессе выполнения

class EmptyResult<T> : Result<T>() // если задача ещё вообще не запускалась