package com.example.tpfinal.ViewModel

import androidx.lifecycle.ViewModel
import com.example.tpfinal.data.UserDB
import com.example.tpfinal.model.Book

class BookViewModel: ViewModel() {

    private val booksDao = UserDB.getInstanceBookTable().bookDao()

    fun insetBook(book: Book){
        booksDao.insert(book = book)
    }

    fun getAllBooks(id: Int): List<Book>{
        return booksDao.getAllBooks(id)
    }

    fun deleteBook(book: Book){
        booksDao.delete(book)
    }

}