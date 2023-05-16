package com.example.sibintektestapp.tasks

import android.os.Looper
import retrofit2.Callback
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

private val executorService = Executors.newCachedThreadPool() // java'вский механизм, чтобы создавать синхронные задачи
private val handler = android.os.Handler(Looper.getMainLooper())

// собственная реализация Promise
class SimpleTask<T>(
    private val callable: Callable<T>
) : Task<T> {

    private val future: Future<*>
    private var result: Result<T> = PendingResult() // PendingResult т.к. задача стартует в блоке init

    init { // запуск задачи на выполнение
        future = executorService.submit {
            result = try {
                SuccessResult(callable.call()) // если успешно то запись данных
            } catch (e: Throwable) {
                ErrorResult(e) // иначе запись ошибки
            }
        }
    }

    private var valueCallback: CallBack<T>? = null // поле для слушателя
    private var errorCallback: CallBack<Throwable>? = null // поле для слушателя

    override fun onSuccess(callback: CallBack<T>): Task<T> {
        this.valueCallback = callback // регистрация слушателя
        notifyListeners()
        return this
    }

    override fun onError(callback: CallBack<Throwable>): Task<T> {
        this.errorCallback = callback // регистрация слушателя
        notifyListeners()
        return this
    }

    override fun cancel() {
        clear()
        future.cancel(true) // отменён
    }

    override fun await(): T { /// синхронный метод получения результатов задачи
        future.get() // get делает то же самое что и await // перейдёт на следующую строку только если блок init асинхронно весь выполнится
        val result = this.result
        if (result is SuccessResult) return result.data
        else throw (result as ErrorResult).error
    }

    private fun notifyListeners() {
        handler.post { // в Handler.post чтобы все данные передавались исключително в главном потоке
            val result = this.result
            val callback = this.valueCallback
            val errorCallback = this.errorCallback
            if (result is SuccessResult && callback != null) {
                callback(result.data) // вызываем callBack с успешным результатом
                clear()
            } else if (result is ErrorResult && errorCallback != null) {
                errorCallback.invoke(result.error) // вызываем callBack с ошибкой
                clear()
            }
        }
    }
    private fun clear() { // очищаем все callback'и
        valueCallback = null
        errorCallback = null
    }

}