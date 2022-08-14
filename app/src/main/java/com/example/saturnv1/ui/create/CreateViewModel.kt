package com.example.saturnv1.ui.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.saturnv1.data.ProductRepository
import com.example.saturnv1.model.Product
import kotlinx.coroutines.launch

class CreateViewModel : ViewModel() {

    private val productRepository =  ProductRepository()

    fun validateFields(name_: String, type_: String, price_: Int, desc_: String) {
        viewModelScope.launch {
            val product = Product(productName = name_, productType = type_, productPrice = price_, productDescription =  desc_)
            val result = productRepository.createProduct(product)
        }
    }
}