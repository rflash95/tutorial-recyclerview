package com.teknorial.mybooklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    //ViewHolder adalah class yang menyimpan referensi layout item_list
    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvAuthor: TextView = view.findViewById(R.id.tvAuthor)
    }

    //Membuat layout item_list sebagai item untuk RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)

        return BookViewHolder(view)
    }

    //Pengaturan data pada item setiap list dari RecyclerView
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.tvTitle.text = books[position].title
        holder.tvAuthor.text = books[position].author

    }

    //Mengembalikan nilai panjang dari data
    override fun getItemCount(): Int {
        return books.size
    }

}