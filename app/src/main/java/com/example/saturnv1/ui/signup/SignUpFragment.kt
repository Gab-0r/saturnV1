package com.example.saturnv1.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.saturnv1.databinding.FragmentSignUpBinding
import com.google.android.material.snackbar.Snackbar

class SignUpFragment : Fragment() {

    private lateinit var signUpBinding: FragmentSignUpBinding
    private lateinit var signUpviewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        signUpBinding = FragmentSignUpBinding.inflate(inflater, container, false)
        signUpviewModel = ViewModelProvider(this)[SignUpViewModel::class.java]

        signUpviewModel.erroMsg.observe(viewLifecycleOwner){//Observador del mensaje de contraseña
            showErrorMsg(it)
        }

        signUpviewModel.registerSuccess.observe(viewLifecycleOwner){uid ->
            goToLogin()
        }

        with(signUpBinding){
            registerButton.setOnClickListener { //Capturar los datos del registro

                //Se llama la función del chequeo de campos
                signUpviewModel.checkFields(nameTextInputLayout.text.toString(),
                    emailTextEmailAddress2.text.toString(),
                    passwordTextTextPassword.text.toString(),
                    confirmPasswordTextPassword2.text.toString())
            }
        }
        return signUpBinding.root
    }

    //Función para imprimir el mensaje de error
    private fun showErrorMsg(msg_: String?) {
        Toast.makeText(requireActivity(), msg_, Toast.LENGTH_LONG).show()
    }

    fun goToLogin(){
        findNavController().navigate(SignUpFragmentDirections.actionNavigationSignUpToNavigationLogin())
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }
}