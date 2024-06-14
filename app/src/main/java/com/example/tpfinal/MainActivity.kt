package com.example.tpfinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tpfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
    companion object{
        var idUser:Int = 1
        var EditId : Int = 0
        var Editnombre: String = ""
        var Editautor: String = ""
        var Editaño: Int = 0
    }
}