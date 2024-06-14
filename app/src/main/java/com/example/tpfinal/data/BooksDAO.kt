package com.example.tpfinal.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tpfinal.model.Book

@Dao
interface BooksDAO{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(book: Book)

    @Query("SELECT * FROM Book WHERE usuario = :id ORDER BY id ASC")
    fun getAllBooks(id: Int): List<Book>

    @Delete
    fun delete(book: Book)

}