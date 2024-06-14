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
import com.example.tpfinal.MainActivity.Companion.idUser
import com.example.tpfinal.R
import com.example.tpfinal.ViewModel.BookViewModel
import com.example.tpfinal.ViewModel.UserViewModel
import com.example.tpfinal.databinding.FragmentLoginBinding
import com.example.tpfinal.model.User

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val userVM: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        with(binding) {

            btnRegistro.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_loginFragment_to_registerFragment)
            }
            btnLogin.setOnClickListener {

                val name = TFUsuario.text.toString()
                val pass = TFContra.text.toString()

                if (validData(name, pass)){
                    val usuario: User? = userVM.searchUser(name, pass)

                    if (usuario != null) {

                        idUser = usuario.id

                        view?.findNavController()
                                ?.navigate(R.id.action_loginFragment_to_bookFragment)

                    }else{
                        Toast.makeText(requireContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(requireContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                }

            }
        }

        return binding.root
    }
    private fun validData(user: String, pass: String): Boolean = user.isNotBlank() && pass.isNotBlank()
}