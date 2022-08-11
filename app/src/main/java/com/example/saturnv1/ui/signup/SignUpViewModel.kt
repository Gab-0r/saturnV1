package com.example.saturnv1.ui.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.saturnv1.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private val userRepository = UserRepository()///Repositorio (Fuente de datos  para la aplicación)

    private val _errorMsg: MutableLiveData<String> = MutableLiveData()//Mensaje de error
    val erroMsg: LiveData<String> = _errorMsg //Mensaje de error que se le pasa a la vista

    fun checkFields(name_: String, email_: String, pass_: String, confPass_: String) {
        if(name_.isEmpty() || email_.isEmpty() || pass_.isEmpty() || confPass_.isEmpty())
            _errorMsg.value = "Todos los campos deben ser llenados"
        else
            if(pass_ != confPass_)
                _errorMsg.value = "Las contraseñas deben de ser iguales"
            else
                //Si se cumplen todas las validaciones se hace el Login

                //Lanzar corrutina para operacion en base de datos (Se usa el despachador IO)
                GlobalScope.launch(Dispatchers.IO) {
                    userRepository.registerUser(name_, email_, pass_, confPass_)
                }


    }
}