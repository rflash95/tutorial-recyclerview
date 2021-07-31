package com.teknorial.mybooklist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvBooks = findViewById<RecyclerView>(R.id.recyclerview)
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etAuthor = findViewById<EditText>(R.id.etAuthor)
        val btnAdd = findViewById<Button>(R.id.btnAdd)

        //data buku awal dengan menggunakan MutableList
        val bookList = mutableListOf(
            Book("Sebuah Seni untuk Bersikap Bodo Amat", "Mark Manson"),
            Book("Atomic Habits: Perubahan Kecil yang Memberikan Hasil Luar Biasa", "James Clear"),
            Book("Grit: Kekuatan Passion dan Kegigihan", "Angela Duckworth"),
            Book("Mindset", "Carol S. Dweck, Ph.d."),
        )

        //memasukkan data ke dalam adapter dan menampilkah ke dalam RecyclerView
        val adapter = BookAdapter(bookList)
        rvBooks.adapter = adapter
        rvBooks.layoutManager = LinearLayoutManager(this)

        //event click pada button add
        btnAdd.setOnClickListener {
            //mengambil value dari kedua EditText
            val title = etTitle.text.toString()
            val author = etAuthor.text.toString()

            val book = Book(title, author)

            //menambahkan data baru ke dalam list
            bookList.add(book)
            //memberi tahu adapter bahwa item baru telah ditambahkan
            adapter.notifyItemInserted(bookList.size - 1)
        }

    }
}