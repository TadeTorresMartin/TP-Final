package com.example.tpfinal

import android.app.Application

class UserDBApp: Application() {

    companion object{
        lateinit var instance: UserDBApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}