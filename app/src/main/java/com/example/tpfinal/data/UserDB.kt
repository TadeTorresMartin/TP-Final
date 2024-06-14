package com.example.tpfinal.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tpfinal.UserDBApp
import com.example.tpfinal.constants.Constants
import com.example.tpfinal.model.Book
import com.example.tpfinal.model.User


@Database(entities = [User::class, Book::class], version = 2, exportSchema = false)
abstract class UserDB: RoomDatabase() {

    abstract fun userDao(): UserDAO
    abstract fun bookDao(): BooksDAO

    companion object{

        @Volatile
        private var INSTANCE: UserDB? = null

        fun getInstanceUserTable(): UserDB{

            var LocalInstance = INSTANCE

            if(LocalInstance != null){
                return LocalInstance
            }

            synchronized(this){

                val db = Room.databaseBuilder(
                    UserDBApp.instance.applicationContext,
                    UserDB::class.java,
                    Constants.DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = db
                return db
            }
        }

        fun getInstanceBookTable(): UserDB{

            var LocalInstance = INSTANCE

            if(LocalInstance != null){
                return LocalInstance
            }

            synchronized(this){

                val db = Room.databaseBuilder(
                    UserDBApp.instance.applicationContext,
                    UserDB::class.java,
                    Constants.DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = db
                return db
            }
        }

    }
}