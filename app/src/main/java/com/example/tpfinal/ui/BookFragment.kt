package com.example.tpfinal.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.tpfinal.MainActivity.Companion.idUser
import com.example.tpfinal.R
import com.example.tpfinal.ViewModel.BookViewModel
import com.example.tpfinal.adapter.BooksAdapter
import com.example.tpfinal.adapter.BooksViewHolder
import com.example.tpfinal.databinding.FragmentItemBinding
import com.example.tpfinal.databinding.FragmentItemListBinding

class BookFragment() : Fragment() {

    private lateinit var binding: FragmentItemListBinding

    private val BooksVM: BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemListBinding.inflate(inflater, container, false)

        initRecycler(binding.ListaLibros)

        with(binding){
            vueltaAtras.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_bookFragment_to_loginFragment)
            }

            agregarLibro.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_bookFragment_to_registBookFragment)
            }
        }

        return binding.root
    }

    private fun initRecycler(recycler: RecyclerView){

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = BooksAdapter(BooksVM.getAllBooks(idUser))
    }

}