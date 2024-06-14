package com.example.tpfinal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tpfinal.R
import com.example.tpfinal.model.Book

class BooksAdapter(private val BooksList: List<Book>) : RecyclerView.Adapter<BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BooksViewHolder(layoutInflater.inflate(R.layout.fragment_item, parent, false))
    }

    override fun getItemCount(): Int = BooksList.size

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val item = BooksList[position]
        holder.render(item)

    }
}