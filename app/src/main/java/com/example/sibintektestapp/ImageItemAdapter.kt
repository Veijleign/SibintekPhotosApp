package com.example.sibintektestapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sibintektestapp.databinding.ItemPhotoBinding
import com.example.sibintektestapp.model.ReceivedPhotosList.ReceivedDataItem

interface PhotoActionListener {
    fun onPhotoDetails(photo: ReceivedDataItem)
}

class ImageItemAdapter(
    private val actionListener: PhotoActionListener,
    var photos: MutableList<ReceivedDataItem>,
    private val context: Context
) : RecyclerView.Adapter<ImageItemAdapter.PhotosViewHolder>(), View.OnClickListener { // т.к. мы будем слышать события нажатия, адаптер должен реализовывать интерфейс для клика,
                                                                                   // чтобы слышать всё, на что можно нажать

    /*var photos: List<ReceivedDataItem> = emptyList()
        set(value) { // setter нужен, чтобы при изменении photos уведосить recyclerView, что нужно себя обновить
            field = value
            notifyDataSetChanged()
        }*/

    override fun onClick(v: View) {
        val photo = v.tag as ReceivedDataItem // вытаскиваем photo из View
        // здесь можем знать на что конкретно нажали: элемент списка
        when(v.id) {
            //можно добавить другие обработчики событий
            else -> { // нажат элемент списка
                actionListener.onPhotoDetails(photo)
            }
        }
    }

    override fun getItemCount(): Int = // адаптер должен знать сколько элементов в списке // возвращает кол-во этих элементов
        photos.size


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int // используется когда RecyclerView зхчоет создать новый элемент списка, context можно вытащить из parent
    ): PhotosViewHolder { // ViewType исопльзуется когда более одного ипа элементов в списке
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPhotoBinding.inflate(inflater, parent, false) // создаём binding

        binding.root.setOnClickListener(this) // нажали на элмент списка

        return PhotosViewHolder(binding) // возвращаем экземпляр класса
    }

    override fun onBindViewHolder(
        holder: PhotosViewHolder, // используется чтобы обновить элемент списка внутри holder вьюшки из item_photo
        position: Int) { // по position достаём элемент списка
        val photo = photos[position] // достаём фото из списка
        with(holder.binding) {
            holder.itemView.tag = photo // засовываем пользователя в тэг

        }

    }

    class PhotosViewHolder(
        val binding: ItemPhotoBinding // binding в качестве конструктора
    ) : RecyclerView.ViewHolder(binding.root) // передаём разметки в RecyclerView
}
