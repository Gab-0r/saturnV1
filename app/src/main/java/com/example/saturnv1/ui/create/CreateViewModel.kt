package com.example.saturnv1.ui.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.saturnv1.data.ProductRepository
import com.example.saturnv1.data.ResourceRemote
import com.example.saturnv1.model.Product
import kotlinx.coroutines.launch

class CreateViewModel : ViewModel() {

    private val productRepository =  ProductRepository()

    private val _createProductSuccess: MutableLiveData<String?> = MutableLiveData()
    val createProductSuccess: LiveData<String?> = _createProductSuccess

    private val _showMsg: MutableLiveData<String?> = MutableLiveData()//Mensaje de error
    val showMsg: LiveData<String?> = _showMsg //Mensaje de error que se le pasa a la vista

    fun validateFields(name_: String, type_: String, price_: Int, desc_: String) {
        if(name_.isEmpty() || type_.isEmpty() || price_.toString().isEmpty() || desc_.isEmpty())
            _showMsg.postValue("Por favor rellene todos los campos")
        else
            viewModelScope.launch {
                val product = Product(productName = name_, productType = type_, productPrice = price_, productDescription =  desc_)
                val result = productRepository.createProduct(product)
                result.let { resourceRemote->
                    when(resourceRemote){
                        is ResourceRemote.success ->{
                            _createProductSuccess.postValue(result.data)
                            _showMsg.postValue("Producto creado")
                        }
                        is ResourceRemote.error -> {
                            var msg = result.message
                            _showMsg.postValue(msg)
                        }
                        else -> {
                            //Don't use
                        }
                    }
                }
            }
    }
}