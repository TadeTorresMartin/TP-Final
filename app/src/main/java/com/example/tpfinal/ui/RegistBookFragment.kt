package com.example.tpfinal.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.tpfinal.MainActivity.Companion.idUser
import com.example.tpfinal.R
import com.example.tpfinal.ViewModel.BookViewModel
import com.example.tpfinal.databinding.FragmentRegistBookBinding
import com.example.tpfinal.model.Book

class RegistBookFragment() : Fragment() {

    lateinit var binding: FragmentRegistBookBinding

    private val bookVM: BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistBookBinding.inflate(layoutInflater, container, false)

        with(binding) {

            btnRegistro.setOnClickListener {

                val name: String = TFTitulo.text.toString()
                val author: String = TFAutor.text.toString()
                val year: String = TFAO.text.toString()

                if(checkdata(name, author, year)) {

                    val libro = Book(0, name, author, year.toInt(), idUser)
                    bookVM.insetBook(libro)

                    view?.findNavController()?.navigate(R.id.action_registBookFragment_to_bookFragment)

                }else{
                    Toast.
                    makeText(requireContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            vueltaAtras.setOnClickListener {

                view?.findNavController()?.navigate(R.id.action_registBookFragment_to_bookFragment)

            }

        }


        return binding.root
    }

    private fun checkdata(name: String, author: String, year: String): Boolean = name.isNotBlank() && author.isNotBlank() && year.isNotBlank()

}