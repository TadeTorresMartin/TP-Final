package com.example.tpfinal.ViewModel

import androidx.lifecycle.ViewModel
import com.example.tpfinal.data.UserDB
import com.example.tpfinal.model.User

class UserViewModel: ViewModel() {

    private val userDao = UserDB.getInstanceUserTable().userDao()

    fun insertUser(usuario: User){

        userDao.insert(user = usuario)
    }

    fun searchUser(name: String, pass: String): User{

        return userDao.getUser(name, pass)
    }

}