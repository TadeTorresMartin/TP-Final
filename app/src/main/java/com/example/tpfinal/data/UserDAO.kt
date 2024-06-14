package com.example.tpfinal.data

import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tpfinal.model.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User)

    @Query("SELECT * FROM user WHERE name = :name AND pass = :pass")
    fun getUser(name: String, pass: String): User

}