package com.example.tpfinal.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.tpfinal.R
import com.example.tpfinal.ViewModel.UserViewModel
import com.example.tpfinal.databinding.FragmentRegisterBinding
import com.example.tpfinal.model.User

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    private val userVM: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        with(binding){

            vueltaAtras.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_registerFragment_to_loginFragment)
            }

            btnRegistro.setOnClickListener {
                val name = TFUsuario.text.toString()
                val mail = TFMail.text.toString()
                val pass = TFContra.text.toString()

                if (validData(name, mail, pass)){
                    val user = User(id = 0, name = name, mail= mail, pass = pass)

                    userVM.insertUser(user)

                    view?.findNavController()?.navigate(R.id.action_registerFragment_to_loginFragment)
                }else{
                    Toast.makeText(requireContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                }

            }
        }

        return binding.root
    }

    private fun validData(name: String, mail: String, pass: String): Boolean =
        name.isNotBlank() && mail.isNotBlank() && pass.isNotBlank()
}