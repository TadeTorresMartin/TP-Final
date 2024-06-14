package com.example.tpfinal.adapter

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tpfinal.MainActivity.Companion.EditId
import com.example.tpfinal.MainActivity.Companion.Editautor
import com.example.tpfinal.MainActivity.Companion.Editaño
import com.example.tpfinal.MainActivity.Companion.Editnombre
import com.example.tpfinal.R
import com.example.tpfinal.databinding.FragmentItemBinding
import com.example.tpfinal.model.Book

class BooksViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    val binding = FragmentItemBinding.bind(view)

    val titulo = binding.bookName
    val autor = binding.bookAuthor
    val año = binding.bookYear

    fun render(libro: Book){
        titulo.text = libro.title
        autor.text = libro.author
        año.text = libro.year.toString()

        binding.contenedorLibro.setOnClickListener {

            view.findNavController().navigate(R.id.action_bookFragment_to_editBookFragment)
            EditId = libro.id
            Editnombre = libro.title
            Editautor = libro.author
            Editaño = libro.year
        }

    }
}