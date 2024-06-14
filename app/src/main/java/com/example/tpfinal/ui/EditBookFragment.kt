package com.example.tpfinal.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.tpfinal.MainActivity.Companion.EditId
import com.example.tpfinal.MainActivity.Companion.Editautor
import com.example.tpfinal.MainActivity.Companion.Editaño
import com.example.tpfinal.MainActivity.Companion.Editnombre
import com.example.tpfinal.MainActivity.Companion.idUser
import com.example.tpfinal.R
import com.example.tpfinal.ViewModel.BookViewModel
import com.example.tpfinal.databinding.FragmentEditBook2Binding
import com.example.tpfinal.model.Book

class EditBookFragment : Fragment() {

    lateinit var binding: FragmentEditBook2Binding
    private val BooksVM: BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBook2Binding.inflate(inflater, container, false)

        val nombreEntrada = Editnombre
        val autorEntrada = Editautor
        val añoEntrada = Editaño


        with(binding) {

            btnRegistro.setOnClickListener {
                var nombre = TFTitulo.text.toString()
                var autor= TFAutor.text.toString()
                var año =TFAO.text.toString()

                if (!validNombre(nombre)) nombre = nombreEntrada
                if (!validAutor(autor)) autor = autorEntrada
                if (!validAño(año)) año = añoEntrada.toString()

                val libro = Book(
                    EditId,
                    nombre,
                    autor,
                    año.toInt(),
                    idUser
                )

                BooksVM.insetBook(libro)

                view?.findNavController()?.navigate(R.id.action_editBookFragment_to_bookFragment)
            }

            eliminarLibro.setOnClickListener {
                val libro = Book(EditId, nombreEntrada, autorEntrada, añoEntrada, idUser)
                BooksVM.deleteBook(libro)
                BooksVM.getAllBooks(EditId)
                view?.findNavController()?.navigate(R.id.action_editBookFragment_to_bookFragment)
            }
            vueltaAtras.setOnClickListener{

                view?.findNavController()?.navigate(R.id.action_editBookFragment_to_bookFragment)
            }
        }


        return binding.root
    }

    private fun validNombre(nuevo: String): Boolean {

        if(nuevo.isNotBlank()){
            return true
        }else {
            return false
        }
    }

    private fun validAutor(nuevo: String): Boolean {

        if(nuevo.isNotBlank()){
            return true
        }else {
            return false
        }
    }

    private fun validAño(nuevo: String): Boolean {

        if(nuevo.isNotBlank()){
            return true
        }else {
            return false
        }
    }
}